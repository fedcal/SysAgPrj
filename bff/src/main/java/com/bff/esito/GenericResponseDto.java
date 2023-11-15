package com.bff.esito;

import lombok.Data;

@Data
public class GenericResponseDto<T>{
    /**
     * The Esito.
     */
    private Esito esito;
    /**
     * The Payload.
     */
    private T payload;
}
