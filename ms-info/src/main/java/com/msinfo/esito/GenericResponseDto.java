package com.msinfo.esito;

import lombok.Data;

@Data
public class GenericResponseDto<T>{

    private Esito esito;
    private T payload;
}
