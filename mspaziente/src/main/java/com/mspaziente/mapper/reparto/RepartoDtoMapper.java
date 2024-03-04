package com.mspaziente.mapper.reparto;

import com.mspaziente.dto.RepartoDto;
import com.mspaziente.entity.Reparto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoDtoMapper {
    RepartoDtoMapper INSTANCE = Mappers.getMapper(RepartoDtoMapper.class);

    RepartoDto toDto(Reparto entity);
    List<RepartoDto> toDto(List<Reparto> entity);
}
