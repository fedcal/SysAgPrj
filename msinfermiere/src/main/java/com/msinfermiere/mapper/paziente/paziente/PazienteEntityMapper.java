package com.msinfermiere.mapper.paziente.paziente;

import com.msinfermiere.dto.paziente.PazienteDto;
import com.msinfermiere.entity.paziente.Paziente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PazienteEntityMapper {
    PazienteEntityMapper INSTANCE = Mappers.getMapper(PazienteEntityMapper.class);

    Paziente toEntity(PazienteDto dto);
    List<Paziente> toEntity(List<PazienteDto> dto);
}
