package com.msmedico.mapper.medico;
import com.msmedico.dto.MedicoDto;
import com.msmedico.entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicoDtoMapper {
    MedicoDtoMapper INSTANCE = Mappers.getMapper( MedicoDtoMapper.class );
    MedicoDto toDto(Medico entity);
    List<MedicoDto> toDto(List<Medico> entities);
}
