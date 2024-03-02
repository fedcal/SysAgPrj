package com.bff.service.msinfermiere;

import com.bff.controller.msinfermiere.VisitaOperazioniController;
import com.bff.dto.msinfermiere.params.visiteoperazioni.FiltraVisitePrescrizioniParams;
import com.bff.dto.msinfermiere.params.visiteoperazioni.FiltraVisiteSottoministrateInfermieriParams;
import com.bff.dto.msinfermiere.params.visiteoperazioni.SomministraVisitaParams;
import com.bff.dto.msinfermiere.relationentities.VisitaPrescrizioneDto;
import com.bff.dto.msinfermiere.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msinfermiere.api.MsInfermieriVisitaOperazioniControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsInfermiereVisitaOperazioniService {
    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MsInfermieriVisitaOperazioniControllerApi visitaOperazioniControllerApi;
    public List<VisitaPrescrizioneDto> getAllVisitePrescrizioni() {
        GenericResponseDto<List<VisitaPrescrizioneDto>> allVisitePrescrizioni = genericResponseConverter.convertGenericResponseList(
                visitaOperazioniControllerApi.msInfermiereListaPrescrizioniVisite(), VisitaPrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allVisitePrescrizioni.getEsito().getMessaggi());
        return allVisitePrescrizioni.getPayload();
    }

    public List<VisitaPrescrizioneDto> getVisitePrescrizioniFiltrata(FiltraVisitePrescrizioniParams params) {
        GenericResponseDto<List<VisitaPrescrizioneDto>> visitePrescrizioniFiltrata = genericResponseConverter.convertGenericResponseList(
                visitaOperazioniControllerApi.msInfermiereListaPrescrizioniVisiteFiltrata(params.getIdPrescrizioneMedicinale(), params.getIdMedico(), params.getIdVisita(),
                        params.getIdCartellaClinica(), params.getNomeMedico(), params.getCognomeMedico(), params.getNomeVisita(), params.getNomePaziente(), params.getCognomePaziente()),
                VisitaPrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(visitePrescrizioniFiltrata.getEsito().getMessaggi());
        return visitePrescrizioniFiltrata.getPayload();
    }

    public List<VisitaSottoministrazioneInfermiereDto> getAllVisiteSottoministrateInfermieri() {
        GenericResponseDto<List<VisitaSottoministrazioneInfermiereDto>> allVisiteSottoministrateInfermieri = genericResponseConverter.convertGenericResponseList(
                visitaOperazioniControllerApi.msInfermiereListaPrescrizioniVisite(), VisitaSottoministrazioneInfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allVisiteSottoministrateInfermieri.getEsito().getMessaggi());
        return allVisiteSottoministrateInfermieri.getPayload();
    }

    public List<VisitaSottoministrazioneInfermiereDto> getAllVisiteSottoministrateInfermieriFiltrate(FiltraVisiteSottoministrateInfermieriParams params) {
        GenericResponseDto<List<VisitaSottoministrazioneInfermiereDto>> allVisiteSottoministrateInfermieriFiltrate = genericResponseConverter.convertGenericResponseList(
                visitaOperazioniControllerApi.msInfermiereListaVisiteSottoministrateInfermierieFiltrate(params.getIdSottoministrazione(),
                        params.getIdInfermiere(), params.getIdVisita(), params.getIdCartellaClinica(), params.getNomeInfermiere(),
                        params.getCognomeInfermiere(), params.getNomeVisita(), params.getNomePaziente(), params.getCognomePaziente()),
                VisitaSottoministrazioneInfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allVisiteSottoministrateInfermieriFiltrate.getEsito().getMessaggi());
        return allVisiteSottoministrateInfermieriFiltrate.getPayload();
    }

    public VisitaSottoministrazioneInfermiereDto somministraMedicinale(SomministraVisitaParams params) {
        GenericResponseDto<VisitaSottoministrazioneInfermiereDto> allVisiteSottoministrateInfermieriFiltrate = genericResponseConverter.convertGenericResponse(
                visitaOperazioniControllerApi.msInfermiereSomministraVisitaInfermiere(params.getIdInfermiere(), params.getIdVisita(), params.getIdCartellaClinica()), VisitaSottoministrazioneInfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allVisiteSottoministrateInfermieriFiltrate.getEsito().getMessaggi());
        return allVisiteSottoministrateInfermieriFiltrate.getPayload();
    }
}
