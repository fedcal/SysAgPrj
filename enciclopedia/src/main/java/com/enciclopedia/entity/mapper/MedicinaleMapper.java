package com.enciclopedia.entity.mapper;

import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.entity.dto.MedicinaleDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicinaleMapper {
    MedicinaleDto toDto(Medicinale entity);
    List<MedicinaleDto> toDto(List<Medicinale> entity);
}
