package com.mspaziente.mapper.cartellaclinica;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.entity.CartellaClinica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartellaClinicaDtoMapper {
    CartellaClinicaDtoMapper INSTANCE = Mappers.getMapper(CartellaClinicaDtoMapper.class);

    CartellaClinicaDto toDto(CartellaClinica entity);
    List<CartellaClinicaDto> toDto(List<CartellaClinica> entity);
}
