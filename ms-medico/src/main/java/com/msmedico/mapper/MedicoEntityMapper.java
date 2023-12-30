package com.msmedico.mapper;

import com.msmedico.dto.MedicoDto;
import com.msmedico.entity.medico.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicoEntityMapper {
    MedicoEntityMapper INSTANCE = Mappers.getMapper( MedicoEntityMapper.class );
    Medico toEntity(MedicoDto entity);
    List<Medico> toEntity(List<MedicoDto> entities);
}
