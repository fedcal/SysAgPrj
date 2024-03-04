package com.mspaziente.mapper.relationentities.visitamedicacartella;

import com.mspaziente.dto.relationentities.VisitaMedicaCartellaDto;
import com.mspaziente.entity.relationentities.VisitaMedicaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaMedicaCartellaDtoMapper {
    VisitaMedicaCartellaDtoMapper INSTANCE = Mappers.getMapper(VisitaMedicaCartellaDtoMapper.class);

    VisitaMedicaCartellaDto toDto(VisitaMedicaCartella entity);
    List<VisitaMedicaCartellaDto> toDto(List<VisitaMedicaCartella> entity);
}
