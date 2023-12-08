package com.bff.esito;

import com.bff.dto.CustomPageImpl;
import com.bff.esito.costants.SeveritaMessaggioEnum;
import com.bff.exception.EsitoRuntimeException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GenericResponseConverter {
    /**
     * The Object mapper.
     */
    private final ObjectMapper objectMapper;

    /**
     * The Esito messaggi request context holder.
     */
    private final EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    /**
     * Convert generic response generic response dto.
     *
     * @param <T>          the type parameter
     * @param response     the response
     * @param payloadClass the payload class
     * @return the generic response dto
     */
    public <T> GenericResponseDto<T> convertGenericResponse(Object response, Class<T> payloadClass) {
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(GenericResponseDto.class, payloadClass);
            return objectMapper.readValue(objectMapper.writeValueAsBytes(response), javaType);
        } catch (IOException e) {
            Messaggio messaggio = Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("ERR999").build();
            esitoMessaggiRequestContextHolder.getMessaggi().add(messaggio);
            throw new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Convert generic response list generic response dto.
     *
     * @param <T>          the type parameter
     * @param response     the response
     * @param payloadClass the payload class
     * @return the generic response dto
     */
    public <T> GenericResponseDto<List<T>> convertGenericResponseList(Object response, Class<T> payloadClass) {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, payloadClass);
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(GenericResponseDto.class, collectionType);
            return objectMapper.readValue(objectMapper.writeValueAsBytes(response), javaType);
        } catch (IOException e) {
            Messaggio messaggio = Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("ERR999").build();
            esitoMessaggiRequestContextHolder.getMessaggi().add(messaggio);
            throw new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Convert generic response page generic response dto.
     *
     * @param <T>          the type parameter
     * @param response     the response
     * @param payloadClass the payload class
     * @return the generic response dto
     */
    public <T> GenericResponseDto<Page<T>> convertGenericResponsePage(Object response, Class<T> payloadClass) {
        try {
            JavaType innerType = objectMapper.getTypeFactory().constructParametricType(CustomPageImpl.class, payloadClass);
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(GenericResponseDto.class, innerType);
            return objectMapper.readValue(objectMapper.writeValueAsBytes(response), javaType);
        } catch (IOException e) {
            Messaggio messaggio = Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("ERR999").build();
            esitoMessaggiRequestContextHolder.getMessaggi().add(messaggio);
            throw new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Convert generic response generic response dto.
     *
     * @param inputStream the input stream
     * @return the generic response dto
     */
    public GenericResponseDto<Void> convertGenericResponse(InputStream inputStream) {
        try {
            TypeReference<GenericResponseDto<Void>> typeReference = new TypeReference<>() {
            };
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            Messaggio messaggio = Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("ERR999").build();
            esitoMessaggiRequestContextHolder.getMessaggi().add(messaggio);
            throw new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
