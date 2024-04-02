package com.msmedico.mapper.relationentities.repartomedico;

import com.msmedico.dto.relationentities.RepartoMedicoDto;
import com.msmedico.entity.relationentities.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoMedicoDtoMapper {
    RepartoMedicoDtoMapper INSTANCE = Mappers.getMapper(RepartoMedicoDtoMapper.class);

    RepartoMedicoDto toDto(RepartoMedico entity);
    List<RepartoMedicoDto> toDto(List<RepartoMedico> entities);
}
