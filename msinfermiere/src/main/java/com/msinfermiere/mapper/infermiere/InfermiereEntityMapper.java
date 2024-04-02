package com.msinfermiere.mapper.infermiere;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.entity.Infermiere;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InfermiereEntityMapper {
    InfermiereEntityMapper INSTANCE = Mappers.getMapper(InfermiereEntityMapper.class);
    Infermiere toEntity(InfermiereDto dto);
    List<Infermiere> toEntity(List<InfermiereDto> dto);
}
