package com.bff.service.msinfermiere;

import com.bff.dto.msinfermiere.params.visiteoperazioni.FiltraVisitePrescrizioniParams;
import com.bff.dto.msinfermiere.params.visiteoperazioni.FiltraVisiteSottoministrateInfermieriParams;
import com.bff.dto.msinfermiere.params.visiteoperazioni.SomministraVisitaParams;
import com.bff.dto.msinfermiere.relationentities.VisitaPrescrizioneDto;
import com.bff.dto.msinfermiere.relationentities.VisitaEffettuataInfermiereDto;
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

    public List<VisitaEffettuataInfermiereDto> getAllVisiteSottoministrateInfermieri() {
        GenericResponseDto<List<VisitaEffettuataInfermiereDto>> allVisiteSottoministrateInfermieri = genericResponseConverter.convertGenericResponseList(
                visitaOperazioniControllerApi.msInfermiereListaPrescrizioniVisite(), VisitaEffettuataInfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allVisiteSottoministrateInfermieri.getEsito().getMessaggi());
        return allVisiteSottoministrateInfermieri.getPayload();
    }

    public List<VisitaEffettuataInfermiereDto> getAllVisiteSottoministrateInfermieriFiltrate(FiltraVisiteSottoministrateInfermieriParams params) {
        GenericResponseDto<List<VisitaEffettuataInfermiereDto>> allVisiteSottoministrateInfermieriFiltrate = genericResponseConverter.convertGenericResponseList(
                visitaOperazioniControllerApi.msInfermiereListaVisiteEffettuateInfermierieFiltrata(params.getIdSottoministrazione(),
                        params.getIdInfermiere(), params.getIdVisita(), params.getIdCartellaClinica(), params.getNomeInfermiere(),
                        params.getCognomeInfermiere(), params.getNomeVisita(), params.getNomePaziente(), params.getCognomePaziente()),
                VisitaEffettuataInfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allVisiteSottoministrateInfermieriFiltrate.getEsito().getMessaggi());
        return allVisiteSottoministrateInfermieriFiltrate.getPayload();
    }

    public VisitaEffettuataInfermiereDto somministraMedicinale(SomministraVisitaParams params) {
        GenericResponseDto<VisitaEffettuataInfermiereDto> allVisiteSottoministrateInfermieriFiltrate = genericResponseConverter.convertGenericResponse(
                visitaOperazioniControllerApi.msInfermiereEffettuaVisitaInfermiere(params.getIdInfermiere(), params.getIdVisita(), params.getIdCartellaClinica()), VisitaEffettuataInfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allVisiteSottoministrateInfermieriFiltrate.getEsito().getMessaggi());
        return allVisiteSottoministrateInfermieriFiltrate.getPayload();
    }
}
