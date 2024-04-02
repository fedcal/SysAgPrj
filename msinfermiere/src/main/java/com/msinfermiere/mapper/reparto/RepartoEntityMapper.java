package com.msinfermiere.mapper.reparto;

import com.msinfermiere.dto.RepartoDto;
import com.msinfermiere.entity.Reparto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoEntityMapper {
    RepartoEntityMapper INSTANCE = Mappers.getMapper(RepartoEntityMapper.class);

    Reparto toEntity(RepartoDto entity);
    List<Reparto> toEntity(List<RepartoDto> entity);
}
