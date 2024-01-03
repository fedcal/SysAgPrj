package com.msmedico.mapper.reparto;

import com.msmedico.dto.RepartoDto;
import com.msmedico.entity.Reparto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoEntityMapper {

    RepartoEntityMapper INSTANCE = Mappers.getMapper(RepartoEntityMapper.class);

    Reparto toEntity(RepartoDto dto);

    List<Reparto> toEntity (List<RepartoDto> dtos);
}
