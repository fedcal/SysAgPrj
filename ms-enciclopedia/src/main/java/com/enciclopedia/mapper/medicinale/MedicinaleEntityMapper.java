package com.enciclopedia.mapper.medicinale;

import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinaleEntityMapper {
    MedicinaleEntityMapper INSTANCE = Mappers.getMapper( MedicinaleEntityMapper.class );
    Medicinale toEntity(MedicinaleDto entity);
    List<Medicinale> toEntity(List<MedicinaleDto> entity);
}
