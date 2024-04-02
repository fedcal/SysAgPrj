package com.msmedico.mapper.paziente.diagnosi;

import com.msmedico.dto.paziente.DiagnosiDto;
import com.msmedico.entity.paziente.Diagnosi;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiagnosiEntityMapper {
    DiagnosiEntityMapper INSTANCE = Mappers.getMapper(DiagnosiEntityMapper.class);

    Diagnosi toEnty(DiagnosiDto dto);
    List<Diagnosi> toEnty(List<DiagnosiDto> dtos);
}
