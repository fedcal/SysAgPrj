package com.msinfo.mapper.infermieri;

import com.msinfo.dto.InfermiereDto;
import com.msinfo.entity.infermieri.Infermiere;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InfermiereEnityMapper {
    InfermiereEnityMapper INSTANCE = Mappers.getMapper( InfermiereEnityMapper.class );
    Infermiere toEntity(InfermiereDto entity);
    List<Infermiere> toEntity(List<InfermiereDto> entities);
}
