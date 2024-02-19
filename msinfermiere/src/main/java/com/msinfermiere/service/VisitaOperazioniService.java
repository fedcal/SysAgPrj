package com.msinfermiere.service;

import com.msinfermiere.dto.params.visiteoperazioni.FiltraVisitePrescrizioniParams;
import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.entity.relationentites.VisitaPrescrizione;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.Messaggio;
import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import com.msinfermiere.esito.constants.SeveritaMessaggioEnum;
import com.msinfermiere.exception.EsitoRuntimeException;
import com.msinfermiere.mapper.relationentities.visitaprescrizione.VisitaPrescrizioneDtoMapper;
import com.msinfermiere.repository.relationentites.VisitaPrescrizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VisitaOperazioniService {
    @Autowired
    private VisitaPrescrizioneRepository visitaPrescrizioneRepository;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    
    public List<VisitaPrescrizioneDto> getAllVisitePrescrizioni() {
        List<VisitaPrescrizione> visitaPrescrizioneList = visitaPrescrizioneRepository.findAll();
        if(visitaPrescrizioneList.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista prescrizioni visite vuota.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllVisitePrescrizioni");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(visitaPrescrizioneList);
        }
    }

    public List<VisitaPrescrizioneDto> getVisitePrescrizioniFiltrata(FiltraVisitePrescrizioniParams params) {
        checkParams(params);
        List<VisitaPrescrizione> findById = findMedicinalePrescrizioneById(params);
        List<VisitaPrescrizione> findByString = findMedicinalePrescrizioneByString(params);

        if(findByString!=null && findById!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna prescrizione medicinale.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPrescrizioniMedicinaliFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(findById!=null){
            return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(findById);
        }
        if(findByString!=null){
            return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(findByString);
        }
        return new ArrayList<>();
    }

    private List<VisitaPrescrizione> findMedicinalePrescrizioneByString(FiltraVisitePrescrizioniParams params) {
        List<VisitaPrescrizione> visitaPrescrizioneList = new ArrayList<>();
        if(StringUtils.hasLength(params.getNomeVisita())){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByNomeMedicinale(params.getNomeVisita());
        }
        if(StringUtils.hasLength(params.getNomeMedico())&&StringUtils.hasLength(params.getCognomeMedico())){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByNomeAndCognomeMedico(params.getNomeMedico(),params.getCognomeMedico());
        }
        if(StringUtils.hasLength(params.getNomePaziente())&&StringUtils.hasLength(params.getCognomePaziente())){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByNomeAndCognomePaziente(params.getNomePaziente(),params.getCognomePaziente());
        }
        if(StringUtils.hasLength(params.getNomeMedico())){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByNomeMedico(params.getNomeMedico());
        }
        if(StringUtils.hasLength(params.getCognomeMedico())){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByCognomeMedico(params.getCognomeMedico());
        }
        if(StringUtils.hasLength(params.getNomePaziente())){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByNomePaziente(params.getNomePaziente());
        }
        if(StringUtils.hasLength(params.getCognomePaziente())){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByCognomePaziente(params.getCognomePaziente());
        }
        return visitaPrescrizioneList;

    }

    private List<VisitaPrescrizione> findMedicinalePrescrizioneById(FiltraVisitePrescrizioniParams params) {
        List<VisitaPrescrizione> visitaPrescrizioneList = new ArrayList<>();
        if(params.getIdVisita()!=null){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByIdMedicinale(params.getIdVisita());
        }
        if(params.getIdPrescrizioneMedicinale()!=null){
            visitaPrescrizioneList = Arrays.asList(visitaPrescrizioneRepository.findById(params.getIdPrescrizioneMedicinale()).get());
        }
        if(params.getIdMedico()!=null){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdCartellaClinica()!=null){
            visitaPrescrizioneList = visitaPrescrizioneRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        }
        return visitaPrescrizioneList;
    }

    private void checkParams(FiltraVisitePrescrizioniParams params) {

        boolean verifyId = params.getIdVisita()==null && params.getIdPrescrizioneMedicinale()==null && params.getIdMedico()==null
                && params.getIdCartellaClinica()==null;
        boolean verifyString = params.getCognomeMedico()==null && params.getNomeMedico()==null && params.getNomeVisita()==null &&
                params.getNomePaziente()==null && params.getCognomePaziente()==null;
        if(verifyId && verifyString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getVisitePrescrizioniFiltrata");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
