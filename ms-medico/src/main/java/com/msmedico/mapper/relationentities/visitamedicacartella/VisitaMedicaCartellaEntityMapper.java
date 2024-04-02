package com.msmedico.mapper.relationentities.visitamedicacartella;

import com.msmedico.dto.relationentities.VisitaMedicaCartellaDto;
import com.msmedico.entity.relationentities.VisitaMedicaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaMedicaCartellaEntityMapper {
    VisitaMedicaCartellaEntityMapper INSTANCE = Mappers.getMapper(VisitaMedicaCartellaEntityMapper.class);

    VisitaMedicaCartella toEntity(VisitaMedicaCartellaDto dto);
    List<VisitaMedicaCartella> toEntity(List<VisitaMedicaCartellaDto> dtos);
}
