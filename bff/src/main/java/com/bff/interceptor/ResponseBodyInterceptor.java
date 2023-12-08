package com.bff.interceptor;

import com.bff.service.LoggingService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class ResponseBodyInterceptor implements ResponseBodyAdvice<Object> {
    /**
     * The Logging service.
     */
    private final LoggingService loggingService;

    /**
     * Supports boolean.
     *
     * @param returnType    the return type
     * @param converterType the converter type
     * @return the boolean
     */
    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * Before body write object.
     *
     * @param body                  the body
     * @param returnType            the return type
     * @param selectedContentType   the selected content type
     * @param selectedConverterType the selected converter type
     * @param request               the request
     * @param response              the response
     * @return the object
     */
    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType,
                                  @NotNull MediaType selectedContentType, @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response) {
        loggingService.displayResp(((ServletServerHttpRequest) request).getServletRequest(), ((ServletServerHttpResponse) response).getServletResponse(), body);
        return body;
    }
}
