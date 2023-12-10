package com.msinfo.mapper.infermieri;

import com.msinfo.dto.InfermiereDto;
import com.msinfo.entity.infermieri.Infermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface InfermiereDtoMapper {
    InfermiereDtoMapper INSTANCE = Mappers.getMapper( InfermiereDtoMapper.class );
    InfermiereDto toDto(Infermiere entity);
    List<InfermiereDto> toDto(List<Infermiere> entities);
}
