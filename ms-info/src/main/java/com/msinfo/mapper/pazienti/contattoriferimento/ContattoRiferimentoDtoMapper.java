package com.msinfo.mapper.pazienti.contattoriferimento;

import com.msinfo.dto.ContattoRiferimentoDto;
import com.msinfo.entity.pazienti.ContattoRiferimento;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ContattoRiferimentoDtoMapper {
    ContattoRiferimentoEntityMapper INTERFACE = Mappers.getMapper(ContattoRiferimentoEntityMapper.class);

    ContattoRiferimentoDto toDto(ContattoRiferimento entity);
    List<ContattoRiferimentoDto> toDto(List<ContattoRiferimento> entity);
}
