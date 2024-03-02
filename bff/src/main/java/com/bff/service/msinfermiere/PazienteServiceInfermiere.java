package com.bff.service.msinfermiere;

import com.bff.dto.msinfermiere.params.PazienteFiltratiParams;
import com.bff.dto.msinfermiere.paziente.PazienteDto;
import com.bff.dto.msinfermiere.relationentities.MedicinalePrescrizioneDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msinfermiere.api.MsInfermieriPazienteControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PazienteServiceInfermiere {
    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MsInfermieriPazienteControllerApi pazienteControllerApi;
    public List<PazienteDto> getAllPazienti() {
        GenericResponseDto<List<PazienteDto>> allPazienti = genericResponseConverter.convertGenericResponseList(
                pazienteControllerApi.msInfermiereListaPazienti(),PazienteDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allPazienti.getEsito().getMessaggi());
        return allPazienti.getPayload();
    }

    public List<PazienteDto> getPazientiFiltrati(PazienteFiltratiParams params) {
        GenericResponseDto<List<PazienteDto>> allPazienti = genericResponseConverter.convertGenericResponseList(
                pazienteControllerApi.msInfermiereListaPazientiFiltrati(params.getIdPaziente(), params.getNome(), params.getCognome()),
                PazienteDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allPazienti.getEsito().getMessaggi());
        return allPazienti.getPayload();
    }
}
