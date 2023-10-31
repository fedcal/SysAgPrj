package com.centromessaggistica.exception;

import org.springframework.http.HttpStatus;

public class EsitoRuntimeException extends RuntimeException{
    private String operationId;
    private HttpStatus returnStatus;

    public EsitoRuntimeException(){
        super();
    }

    public EsitoRuntimeException(String operationId, HttpStatus returnStatus) {
        super();
        this.operationId = operationId;
        this.returnStatus = returnStatus;

    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public HttpStatus getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(HttpStatus returnStatus) {
        this.returnStatus = returnStatus;
    }
}
