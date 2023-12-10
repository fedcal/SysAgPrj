package com.msinfo.mapper.reparto;

import com.msinfo.dto.RepartoDto;
import com.msinfo.entity.reparto.Reparto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoDtoMapper {
    RepartoDtoMapper INSTANCE = Mappers.getMapper(RepartoDtoMapper.class);

    RepartoDto toDto(Reparto entity);
    List<RepartoDto> toDto(List<Reparto> entity);
}
