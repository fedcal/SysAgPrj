package com.msinfo.mapper.specialista;

import com.msinfo.dto.SpecialistaDto;
import com.msinfo.entity.specialista.Specialista;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SpecialistaDtoMapper {
    SpecialistaDtoMapper INSTANCE = Mappers.getMapper(SpecialistaDtoMapper.class);

    SpecialistaDto toDto(Specialista entity);
    List<SpecialistaDto> toDto(List<Specialista> entity);
}
