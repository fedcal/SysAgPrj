package com.bff.service.msinfo;

import com.bff.dto.msinfo.ProfiloDto;
import com.bff.dto.msinfo.params.profilo.AddProfiloParams;
import com.bff.dto.msinfo.params.profilo.ModifyProfiloParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.info.api.ProfiloControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfiloService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private ProfiloControllerApi profiloControllerApi;

    public List<ProfiloDto> getAll() {
        GenericResponseDto<List<ProfiloDto>> getAll = genericResponseConverter.convertGenericResponseList(
                profiloControllerApi.getAllProfilo(), ProfiloDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(getAll.getEsito().getMessaggi());
        return getAll.getPayload();
    }

    public ProfiloDto getInfo(Integer id) {
        GenericResponseDto<ProfiloDto> getInfo = genericResponseConverter.convertGenericResponse(
                profiloControllerApi.getInfoProfilo(id), ProfiloDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(getInfo.getEsito().getMessaggi());
        return getInfo.getPayload();
    }

    public ProfiloDto aggiuntaProfilo(AddProfiloParams params) {
        GenericResponseDto<ProfiloDto> aggiuntaProfilo = genericResponseConverter.convertGenericResponse(
                profiloControllerApi.addProfilo(params.getTipo(), params.getDescrizione()), ProfiloDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiuntaProfilo.getEsito().getMessaggi());
        return aggiuntaProfilo.getPayload();
    }

    public ProfiloDto modifcaProfilo(ModifyProfiloParams params) {
        GenericResponseDto<ProfiloDto> modifcaProfilo = genericResponseConverter.convertGenericResponse(
                profiloControllerApi.modifyProfilo(params.getIdProfilo(), params.getNuovoTipo(), params.getNuovaDescrizione()),
                ProfiloDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(modifcaProfilo.getEsito().getMessaggi());
        return modifcaProfilo.getPayload();
    }
}
