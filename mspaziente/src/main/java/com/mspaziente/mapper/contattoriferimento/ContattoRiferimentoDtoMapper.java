package com.mspaziente.mapper.contattoriferimento;

import com.mspaziente.dto.ContattoRiferimentoDto;
import com.mspaziente.entity.ContattoRiferimento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContattoRiferimentoDtoMapper {
    ContattoRiferimentoDtoMapper INSTANCE = Mappers.getMapper(ContattoRiferimentoDtoMapper.class);

    ContattoRiferimentoDto toDto(ContattoRiferimento entity);
    List<ContattoRiferimentoDto> toDto(List<ContattoRiferimento> entity);
}
