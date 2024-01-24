package com.msmedico.mapper.account.profilo;

import com.msmedico.dto.account.ProfiloDto;
import com.msmedico.entity.account.Profilo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfiloDtoMapper {
    ProfiloDtoMapper INSTANCE = Mappers.getMapper(ProfiloDtoMapper.class);

    ProfiloDto toDto(Profilo entity);
    List<ProfiloDto> toDto(List<Profilo> entities);
}
