package com.msmedico.mapper.relationentities.visitamedicacartella;

import com.msmedico.dto.relationentities.VisitaMedicaCartellaDto;
import com.msmedico.entity.relationentities.VisitaMedicaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaMedicaCartellaDtoMapper {
    VisitaMedicaCartellaDtoMapper INSTANCE = Mappers.getMapper(VisitaMedicaCartellaDtoMapper.class);

    VisitaMedicaCartellaDto toDto(VisitaMedicaCartella entity);
    List<VisitaMedicaCartellaDto> toDto(List<VisitaMedicaCartella> entities);
}
