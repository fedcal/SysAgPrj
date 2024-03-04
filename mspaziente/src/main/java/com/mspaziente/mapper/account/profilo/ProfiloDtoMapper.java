package com.mspaziente.mapper.account.profilo;

import com.mspaziente.dto.account.ProfiloDto;
import com.mspaziente.entity.account.Profilo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfiloDtoMapper {
    ProfiloDtoMapper INSTANCE = Mappers.getMapper(ProfiloDtoMapper.class);

    ProfiloDto toDto(Profilo entity);
    List<ProfiloDto> toDto(List<Profilo> entity);
}
