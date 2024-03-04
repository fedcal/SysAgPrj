package com.mspaziente.mapper.account.operazioneaccount;

import com.mspaziente.dto.account.OperazioneAccountDto;
import com.mspaziente.entity.account.OperazioneAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneAccountEntityMapper {
    OperazioneAccountEntityMapper INSTANCE = Mappers.getMapper(OperazioneAccountEntityMapper.class);

    OperazioneAccount toEntity(OperazioneAccountDto dto);
    List<OperazioneAccount> toEntity(List<OperazioneAccountDto> dto);
}
