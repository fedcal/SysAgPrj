package com.msmedico.mapper.paziente.contattoriferimento;

import com.msmedico.dto.paziente.ContattoRiferimentoDto;
import com.msmedico.entity.paziente.ContattoRiferimento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContattoRiferimentoEntityMapper {
    ContattoRiferimentoEntityMapper INSTANCE = Mappers.getMapper(ContattoRiferimentoEntityMapper.class);

    ContattoRiferimento toEntity(ContattoRiferimentoDto dto);
    List<ContattoRiferimento> toEntity(List<ContattoRiferimentoDto> dtos);
}
