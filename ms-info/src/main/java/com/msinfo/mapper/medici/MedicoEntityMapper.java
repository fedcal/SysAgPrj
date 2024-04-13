package com.msinfo.mapper.medici;

import com.msinfo.dto.MedicoDto;
import com.msinfo.entity.medici.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicoEntityMapper {
    MedicoEntityMapper INSTANCE = Mappers.getMapper( MedicoEntityMapper.class );
    Medico toEntity(MedicoDto entity);
    List<Medico> toEntity(List<MedicoDto> entities);
}
