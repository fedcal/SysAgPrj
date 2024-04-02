package com.msinfermiere.mapper.account.profilo;

import com.msinfermiere.dto.account.ProfiloDto;
import com.msinfermiere.entity.account.Profilo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfiloEntityMapper {
    ProfiloEntityMapper INSTANCE = Mappers.getMapper(ProfiloEntityMapper.class);

    Profilo toDto(ProfiloDto entity);
    List<ProfiloDto> toDto(List<ProfiloDto> entity);
}
