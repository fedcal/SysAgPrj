package com.mspaziente.mapper.relationentities.visitamedicacartella;

import com.mspaziente.dto.relationentities.VisitaMedicaCartellaDto;
import com.mspaziente.entity.relationentities.VisitaMedicaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaMedicaCartellaEntityMapper {
    VisitaMedicaCartellaEntityMapper INSTANCE = Mappers.getMapper(VisitaMedicaCartellaEntityMapper.class);

    VisitaMedicaCartella toEntity(VisitaMedicaCartellaDto dto);
    List<VisitaMedicaCartella> toEntity(List<VisitaMedicaCartellaDto> dto);
}
