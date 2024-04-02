package com.msinfermiere.mapper.paziente.cartellaclinica;

import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import com.msinfermiere.entity.paziente.CartellaClinica;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartellaClinicaEnityMapper {
    CartellaClinicaEnityMapper INSTANCE = Mappers.getMapper(CartellaClinicaEnityMapper.class);

    CartellaClinica toDto(CartellaClinicaDto entity);
    List<CartellaClinica> toDto(List<CartellaClinicaDto> entity);
}
