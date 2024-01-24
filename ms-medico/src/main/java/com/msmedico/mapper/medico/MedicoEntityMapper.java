package com.msmedico.mapper.medico;

import com.msmedico.dto.MedicoDto;
import com.msmedico.entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicoEntityMapper {
    MedicoEntityMapper INSTANCE = Mappers.getMapper( MedicoEntityMapper.class );
    Medico toEntity(MedicoDto dto);
    List<Medico> toEntity(List<MedicoDto> dtos);
}
