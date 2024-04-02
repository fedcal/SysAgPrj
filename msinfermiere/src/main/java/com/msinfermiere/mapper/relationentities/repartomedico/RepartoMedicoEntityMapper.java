package com.msinfermiere.mapper.relationentities.repartomedico;

import com.msinfermiere.dto.relationentities.RepartoMedicoDto;
import com.msinfermiere.entity.relationentites.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoMedicoEntityMapper {
    RepartoMedicoEntityMapper INSTANCE = Mappers.getMapper(RepartoMedicoEntityMapper.class);

    RepartoMedico toDto (RepartoMedicoDto entity);
    List<RepartoMedico> toDto (List<RepartoMedicoDto> entity);
}
