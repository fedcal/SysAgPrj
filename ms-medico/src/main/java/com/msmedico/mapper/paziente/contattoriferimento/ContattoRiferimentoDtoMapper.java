package com.msmedico.mapper.paziente.contattoriferimento;

import com.msmedico.dto.paziente.ContattoRiferimentoDto;
import com.msmedico.entity.paziente.ContattoRiferimento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContattoRiferimentoDtoMapper {
    ContattoRiferimentoDtoMapper INSTANCE = Mappers.getMapper(ContattoRiferimentoDtoMapper.class);

    ContattoRiferimentoDto toDto(ContattoRiferimento entity);
    List<ContattoRiferimentoDto> toDto(List<ContattoRiferimento> entities);
}
