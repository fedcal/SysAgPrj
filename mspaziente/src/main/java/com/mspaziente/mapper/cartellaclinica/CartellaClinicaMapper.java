package com.mspaziente.mapper.cartellaclinica;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.entity.CartellaClinica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartellaClinicaMapper {
    CartellaClinicaMapper INSTANCE = Mappers.getMapper(CartellaClinicaMapper.class);

    CartellaClinica toEntity(CartellaClinicaDto dto);
    List<CartellaClinica> toEntity(List<CartellaClinicaDto> dto);
}
