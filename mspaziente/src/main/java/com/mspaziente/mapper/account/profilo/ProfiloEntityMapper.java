package com.mspaziente.mapper.account.profilo;

import com.mspaziente.dto.account.ProfiloDto;
import com.mspaziente.entity.account.Profilo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfiloEntityMapper {
    ProfiloEntityMapper INSTANCE = Mappers.getMapper(ProfiloEntityMapper.class);

    Profilo toEntity(ProfiloDto dto);
    List<Profilo> toEntity(List<ProfiloDto> dto);
}
