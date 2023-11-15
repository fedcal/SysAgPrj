package com.enciclopedia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class EsitoRuntimeException extends RuntimeException{
    /**
     * The Return status.
     */
    private HttpStatus returnStatus;
}
