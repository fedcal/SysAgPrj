package com.msmedico.mapper.reparto;

import com.msmedico.dto.RepartoDto;
import com.msmedico.entity.Reparto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoEntityMapper {

    RepartoEntityMapper INSTANCE = Mappers.getMapper(RepartoEntityMapper.class);

    Reparto toEntity(RepartoDto dto);

    List<Reparto> toEntity (List<RepartoDto> dtos);
}
