package com.msinfermiere.mapper.relationentities.visitamedicacartella;

import com.msinfermiere.dto.relationentities.VisitaMedicaCartellaDto;
import com.msinfermiere.entity.relationentites.VisitaMedicaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaMedicaCertellaDtoMapper {
    VisitaMedicaCertellaDtoMapper INSTANCE = Mappers.getMapper(VisitaMedicaCertellaDtoMapper.class);

    VisitaMedicaCartellaDto toDto(VisitaMedicaCartella entity);
    List<VisitaMedicaCartellaDto> toDto(List<VisitaMedicaCartella> entity);
}
