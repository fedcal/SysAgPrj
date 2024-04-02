package com.msinfermiere.mapper.paziente.paziente;

import com.msinfermiere.dto.paziente.PazienteDto;
import com.msinfermiere.entity.paziente.Paziente;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PazienteDtoMapper {
    PazienteDtoMapper INSTANCE = Mappers.getMapper(PazienteDtoMapper.class);


    PazienteDto toDto(Paziente entity);
    List<PazienteDto> toDto(List<Paziente> entity);
}
