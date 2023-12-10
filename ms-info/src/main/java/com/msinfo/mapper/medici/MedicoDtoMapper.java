package com.msinfo.mapper.medici;

import com.msinfo.dto.MedicoDto;
import com.msinfo.entity.medici.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface MedicoDtoMapper {
    MedicoDtoMapper INSTANCE = Mappers.getMapper( MedicoDtoMapper.class );
    MedicoDto toDto(Medico entity);
    List<MedicoDto> toDto(List<Medico> entities);
}
