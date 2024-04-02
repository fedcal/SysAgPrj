package com.msinfermiere.mapper.medicinale;

import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinaleEntityMapper {
    MedicinaleEntityMapper INSTANCE = Mappers.getMapper(MedicinaleEntityMapper.class);
    Medicinale toEntity (MedicinaleDto medicinaleDto);
    List<Medicinale> toEntity (List<MedicinaleDto> medicinaleDto);
}
