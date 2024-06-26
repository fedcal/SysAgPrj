package com.msinfo.mapper.account.profilo;

import com.msinfo.dto.ProfiloDto;
import com.msinfo.entity.account.Profilo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfiloDtoMapper {
    ProfiloDtoMapper INSTANCE = Mappers.getMapper(ProfiloDtoMapper.class);
    ProfiloDto toDto(Profilo entity);
    List<ProfiloDto> toDto(List<Profilo> entity);
}
