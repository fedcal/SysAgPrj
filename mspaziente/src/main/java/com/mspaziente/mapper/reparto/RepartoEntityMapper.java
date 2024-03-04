package com.mspaziente.mapper.reparto;

import com.mspaziente.dto.RepartoDto;
import com.mspaziente.entity.Reparto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoEntityMapper {
    RepartoEntityMapper INSTANCE = Mappers.getMapper(RepartoEntityMapper.class);
    Reparto toEntity(RepartoDto entity);
    List<Reparto> toEntity(List<RepartoDto> entity);
}
