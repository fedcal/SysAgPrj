package com.enciclopedia.mapper;

import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface MedicinaleEntityMapper {
    MedicinaleEntityMapper INSTANCE = Mappers.getMapper( MedicinaleEntityMapper.class );
    Medicinale toEntity(MedicinaleDto entity);
    List<Medicinale> toEntity(List<MedicinaleDto> entity);
}
