package com.msinfermiere.mapper.paziente.contattoriferimento;

import com.msinfermiere.dto.paziente.ContattoRiferimentoDto;
import com.msinfermiere.entity.paziente.ContattoRiferimento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContattoRiferimentoDtoMapper {
    ContattoRiferimentoDtoMapper INSTANCE = Mappers.getMapper(ContattoRiferimentoDtoMapper.class);

    ContattoRiferimentoDto toEntity(ContattoRiferimento entity);
    List<ContattoRiferimento> toEntity(List<ContattoRiferimento> entity);
}
