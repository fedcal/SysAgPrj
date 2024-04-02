package com.msinfermiere.mapper.relationentities.repartomedico;

import com.msinfermiere.dto.relationentities.RepartoMedicoDto;
import com.msinfermiere.entity.relationentites.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoMedicoDtoMapper {
    RepartoMedicoDtoMapper INSTANCE = Mappers.getMapper(RepartoMedicoDtoMapper.class);

    RepartoMedicoDto toDto (RepartoMedico entity);
    List<RepartoMedicoDto> toDto (List<RepartoMedico> entity);
}
