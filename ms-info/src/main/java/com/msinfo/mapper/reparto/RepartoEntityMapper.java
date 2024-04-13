package com.msinfo.mapper.reparto;

import com.msinfo.dto.RepartoDto;
import com.msinfo.entity.reparto.Reparto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoEntityMapper {
    RepartoEntityMapper INSTANCE = Mappers.getMapper(RepartoEntityMapper.class);

    Reparto toEntity(RepartoDto entity);
    List<Reparto> toEntity(List<RepartoDto> entity);
}
