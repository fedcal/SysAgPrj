package com.msinfo.mapper.account.operazioneaccount;

import com.msinfo.dto.OperazioneAccountDto;
import com.msinfo.entity.account.OperazioneAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface OperazioneAccountDtoMapper {
    OperazioneAccountDtoMapper INSTANCE = Mappers.getMapper(OperazioneAccountDtoMapper.class);

    OperazioneAccountDto toDto(OperazioneAccount dto);
    List<OperazioneAccountDto> toDto(List<OperazioneAccount> dto);
}
