package com.msinfo.mapper.specialista;

import com.msinfo.dto.SpecialistaDto;
import com.msinfo.entity.specialista.Specialista;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SpecialistaEntityMapper {
    SpecialistaEntityMapper INSTANCE = Mappers.getMapper(SpecialistaEntityMapper.class);

    Specialista toEntity(SpecialistaDto entity);
    List<Specialista> toEntity(List<SpecialistaDto> entity);
}
