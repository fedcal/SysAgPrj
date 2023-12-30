package com.bff.service.msinfo;

import com.bff.dto.msinfo.RepartoDto;
import com.bff.dto.msinfo.params.reparto.AddRepartoParams;
import com.bff.dto.msinfo.params.reparto.ModificaRepartoParams;
import com.bff.dto.msinfo.params.reparto.RicercaRepartoParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.info.api.RepartoControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartoService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private RepartoControllerApi repartoControllerApi;

    public List<RepartoDto> findAll() {
        GenericResponseDto<List<RepartoDto>> findAll = genericResponseConverter.convertGenericResponseList(
          repartoControllerApi.getAllReparto(), RepartoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findAll.getEsito().getMessaggi());
        return findAll.getPayload();
    }

    public RepartoDto findReparto(RicercaRepartoParams params) {
        GenericResponseDto<RepartoDto> findReparto = genericResponseConverter.convertGenericResponse(
                repartoControllerApi.getInfoReparto(params.getIdReparto(), params.getNomeReparto()), RepartoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findReparto.getEsito().getMessaggi());
        return findReparto.getPayload();
    }

    public String deleteReparto(RicercaRepartoParams params) {
        GenericResponseDto<String> findReparto = genericResponseConverter.convertGenericResponse(
                repartoControllerApi.deleteReparto(params.getIdReparto(), params.getNomeReparto()), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findReparto.getEsito().getMessaggi());
        return findReparto.getPayload();
    }

    public RepartoDto modificaReparto(ModificaRepartoParams params) {
        GenericResponseDto<RepartoDto> modificaReparto = genericResponseConverter.convertGenericResponse(
                repartoControllerApi.modificaRepartoInfo(params.getIdRepartoRicerca(), params.getNomeRepartoRicerca(),
                        params.getNomeRepartoNuovo(), params.getDescrizioneNuovo(), params.getAlaRepartoNuovo(),
                        params.getCapoRepartoNuovo()), RepartoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(modificaReparto.getEsito().getMessaggi());
        return modificaReparto.getPayload();
    }

    public RepartoDto aggiuntaReparto(AddRepartoParams params) {
        GenericResponseDto<RepartoDto> aggiuntaReparto = genericResponseConverter.convertGenericResponse(
                repartoControllerApi.addReparto(params.getNomeReparto(), params.getDescrizione(), params.getAlaReparto(),
                params.getCapoReparto()), RepartoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiuntaReparto.getEsito().getMessaggi());
        return aggiuntaReparto.getPayload();
    }
}
