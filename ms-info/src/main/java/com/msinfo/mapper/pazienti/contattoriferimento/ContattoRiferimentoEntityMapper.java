package com.msinfo.mapper.pazienti.contattoriferimento;

import com.msinfo.dto.ContattoRiferimentoDto;
import com.msinfo.entity.pazienti.ContattoRiferimento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContattoRiferimentoEntityMapper {
    ContattoRiferimentoEntityMapper INTERFACE = Mappers.getMapper(ContattoRiferimentoEntityMapper.class);

    ContattoRiferimento toEntity(ContattoRiferimentoDto dto);
    List<ContattoRiferimento> toEntity(List<ContattoRiferimentoDto> dto);

}
