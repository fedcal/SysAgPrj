package com.mspaziente.mapper.contattoriferimento;

import com.mspaziente.dto.ContattoRiferimentoDto;
import com.mspaziente.entity.ContattoRiferimento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContattoRiferimentoMapper {
    ContattoRiferimentoMapper INSTANCE = Mappers.getMapper(ContattoRiferimentoMapper.class);

    ContattoRiferimento toEntity(ContattoRiferimentoDto dto);
    List<ContattoRiferimento> toEntity(List<ContattoRiferimentoDto> dto);
}
