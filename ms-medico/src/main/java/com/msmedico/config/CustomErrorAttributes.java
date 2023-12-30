package com.msmedico.config;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomErrorAttributes extends DefaultErrorAttributes {
    /**
     * The constant DEFAULT_ERROR_MESSAGE.
     */
    public static final String DEFAULT_ERROR_MESSAGE = "Errore interno del sistema";

    /**
     * Gets error attributes.
     *
     * @param webRequest the web request
     * @param options    the options
     * @return the error attributes
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

        Throwable error = this.getError(webRequest);
        BindingResult result = customExtractBindingResult(error);
        Optional.ofNullable(result)
                .filter(r -> r.hasErrors())
                .ifPresent(r ->
                        errorAttributes.put("errors", r.getFieldErrors()
                                .stream()
                                .map(fe -> new FieldError(fe.getField(), fe.getDefaultMessage()))
                                .collect(Collectors.toList())
                        ));

        Integer status = (Integer) errorAttributes.get("status");
        if (status >= 500 && status <= 599) {
            errorAttributes.put("message", DEFAULT_ERROR_MESSAGE);
        }

        errorAttributes.remove("exception");

        return errorAttributes;
    }

    /**
     * Custom extract binding result binding result.
     *
     * @param error the error
     * @return the binding result
     */
    private BindingResult customExtractBindingResult(Throwable error) {
        if (error instanceof BindingResult) {
            return (BindingResult) error;
        } else {
            return error instanceof MethodArgumentNotValidException ? ((MethodArgumentNotValidException) error).getBindingResult() : null;
        }
    }

    /**
     * The type Field error.
     */
    public class FieldError {

        /**
         * The Field.
         */
        private String field;
        /**
         * The Message.
         */
        private String message;

        /**
         * Instantiates a new Field error.
         *
         * @param field   the field
         * @param message the message
         */
        public FieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        /**
         * Gets field.
         *
         * @return the field
         */
        public String getField() {
            return field;
        }

        /**
         * Gets message.
         *
         * @return the message
         */
        public String getMessage() {
            return message;
        }
    }
}
