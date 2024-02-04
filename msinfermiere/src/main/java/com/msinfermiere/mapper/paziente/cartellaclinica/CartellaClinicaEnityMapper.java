package com.msinfermiere.mapper.paziente.cartellaclinica;

import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import com.msinfermiere.entity.paziente.CartellaClinica;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CartellaClinicaEnityMapper {
    CartellaClinicaEnityMapper INSTANCE = Mappers.getMapper(CartellaClinicaEnityMapper.class);

    CartellaClinica toDto(CartellaClinicaDto entity);
    List<CartellaClinica> toDto(List<CartellaClinicaDto> entity);
}
