package com.mspaziente.mapper.cartellaclinica;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.entity.CartellaClinica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartellaClinicaEntityMapper {
    CartellaClinicaEntityMapper INSTANCE = Mappers.getMapper(CartellaClinicaEntityMapper.class);

    CartellaClinica toEntity(CartellaClinicaDto dto);
    List<CartellaClinica> toEntity(List<CartellaClinicaDto> dto);
}
