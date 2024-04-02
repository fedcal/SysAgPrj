package com.msmedico.mapper.account.operazioneaccount;

import com.msmedico.dto.account.OperazioneAccountDto;
import com.msmedico.entity.account.OperazioneAccount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazioneAccountDtoMapper {
    OperazioneAccountDtoMapper INSTANCE = Mappers.getMapper(OperazioneAccountDtoMapper.class);

    OperazioneAccountDto toDto(OperazioneAccount entity);
    List<OperazioneAccountDto> toDto(List<OperazioneAccount> entities);
}
