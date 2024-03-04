package com.mspaziente.mapper.account.operazioneaccount;

import com.mspaziente.dto.account.OperazioneAccountDto;
import com.mspaziente.entity.account.OperazioneAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneAccountDtoMapper {
    OperazioneAccountDtoMapper INSTANCE = Mappers.getMapper(OperazioneAccountDtoMapper.class);

    OperazioneAccountDto toDto(OperazioneAccount entity);
    List<OperazioneAccountDto> toDto(List<OperazioneAccount> entity);
}
