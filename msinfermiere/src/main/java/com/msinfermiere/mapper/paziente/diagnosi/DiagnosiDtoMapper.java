package com.msinfermiere.mapper.paziente.diagnosi;

import com.msinfermiere.dto.paziente.DiagnosiDto;
import com.msinfermiere.entity.paziente.Diagnosi;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiagnosiDtoMapper {
    DiagnosiDtoMapper INSTANCE = Mappers.getMapper(DiagnosiDtoMapper.class);

    DiagnosiDto toDto(Diagnosi dto);
    List<DiagnosiDto> toDto(List<Diagnosi> dto);
}
