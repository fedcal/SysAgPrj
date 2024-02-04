package com.msinfermiere.mapper.account.operazioneaccount;

import com.msinfermiere.dto.account.OperazioneAccountDto;
import com.msinfermiere.entity.account.OperazioneAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface OperazioneEntityMapper {
    OperazioneEntityMapper INSTANCE = Mappers.getMapper(OperazioneEntityMapper.class);

    OperazioneAccount toEntity(OperazioneAccountDto entity);
    List<OperazioneAccountDto> toEntity(List<OperazioneAccountDto> entity);
}
