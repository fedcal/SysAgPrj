package com.mspaziente.mapper.infermiere;

import com.mspaziente.dto.InfermiereDto;
import com.mspaziente.entity.Infermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InfermiereMapper {
    InfermiereMapper INSTANCE = Mappers.getMapper(InfermiereMapper.class);

    Infermiere toEntity(InfermiereDto dto);
    List<Infermiere> toEntity(List<InfermiereDto> dto);
}
