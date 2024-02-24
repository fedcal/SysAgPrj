package com.msinfermiere.service;

import com.msinfermiere.dto.params.visiteoperazioni.FiltraVisitePrescrizioniParams;
import com.msinfermiere.dto.params.visiteoperazioni.FiltraVisiteSottoministrateInfermieriParams;
import com.msinfermiere.dto.params.visiteoperazioni.SomministraVisitaParams;
import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.msinfermiere.entity.Infermiere;
import com.msinfermiere.entity.paziente.CartellaClinica;
import com.msinfermiere.entity.relationentites.VisitaPrescrizione;
import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneInfermiere;
import com.msinfermiere.entity.visitamedica.VisitaMedica;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.Messaggio;
import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import com.msinfermiere.esito.constants.SeveritaMessaggioEnum;
import com.msinfermiere.exception.EsitoRuntimeException;
import com.msinfermiere.mapper.relationentities.visitaprescrizione.VisitaPrescrizioneDtoMapper;
import com.msinfermiere.mapper.relationentities.visitasottoministrzioneinfermiere.VisitaSottoministrazioneInfermiereDtoMapper;
import com.msinfermiere.repository.InfermiereRepository;
import com.msinfermiere.repository.paziente.CartellaClinicaRepository;
import com.msinfermiere.repository.relationentites.VisitaPrescrizioneRepository;
import com.msinfermiere.repository.relationentites.VisitaSottoministrazioneInfermiereRepository;
import com.msinfermiere.repository.visitamedica.VisitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VisitaOperazioniService {
    @Autowired
    private VisitaPrescrizioneRepository visitaPrescrizioneRepository;

    @Autowired
    private VisitaSottoministrazioneInfermiereRepository visitaSottoministrazioneInfermiereRepository;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private VisitaMedicaRepository visitaMedicaRepository;
    @Autowired
    private InfermiereRepository infermiereRepository;
    @Autowired
    private CartellaClinicaRepository cartellaClinicaRepository;

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

        if((findByString==null && findById==null)||(findByString!=null && findByString.isEmpty())||(findById!=null && findById.isEmpty())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna prescrizione medicinale.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPrescrizioniMedicinaliFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(findById!=null && !findById.isEmpty()){
            return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(findById);
        }
        if(findByString!=null && !findByString.isEmpty()){
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

    public List<VisitaSottoministrazioneInfermiereDto> getAllVisiteSottoministrateInfermieri() {

        List<VisitaSottoministrazioneInfermiere> visitaSottoministrazioneInfermiere = visitaSottoministrazioneInfermiereRepository.findAll();
        if(visitaSottoministrazioneInfermiere.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita sottoministrata da nessun infermiere.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllVisiteSottoministrateInfermieri");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getAllVisiteSottoministrateInfermieri");
            return VisitaSottoministrazioneInfermiereDtoMapper.INSTANCE.toDto(visitaSottoministrazioneInfermiere);
        }
    }

    public List<VisitaSottoministrazioneInfermiereDto> getAllVisiteSottoministrateInfermieriFiltrate(FiltraVisiteSottoministrateInfermieriParams params) {
        checkParams(params);

        List<VisitaSottoministrazioneInfermiere> findById = findMedicinaleSottoministrazioneById(params);
        List<VisitaSottoministrazioneInfermiere> findByString = findMedicinaleSottoministrazioneByString(params);

        if((findByString==null && findById==null)||(findByString!=null && findByString.isEmpty())||(findById!=null && findById.isEmpty())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna sottoministrazione medicinale da nessun infermiere.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllVisiteSottoministrateInfermieriFiltrate");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(findById!=null && !findById.isEmpty()){
            return VisitaSottoministrazioneInfermiereDtoMapper.INSTANCE.toDto(findById);
        }
        if(findByString!=null && !findByString.isEmpty()){
            return VisitaSottoministrazioneInfermiereDtoMapper.INSTANCE.toDto(findByString);
        }
        return new ArrayList<>();
    }

    private List<VisitaSottoministrazioneInfermiere> findMedicinaleSottoministrazioneByString(FiltraVisiteSottoministrateInfermieriParams params) {
        List<VisitaSottoministrazioneInfermiere> visitaSottoministrazioneInfermiereList = new ArrayList<>();

        if(StringUtils.hasLength(params.getNomePaziente()) && StringUtils.hasLength(params.getCognomePaziente())){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByNomeAndCognomePaziente(params.getNomePaziente(),params.getCognomePaziente());
        }
        if(StringUtils.hasLength(params.getNomeInfermiere())&& StringUtils.hasLength(params.getCognomeInfermiere())){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByNomeAndCognomeInfermiere(params.getNomeInfermiere(),params.getCognomeInfermiere());
        }
        if(StringUtils.hasLength(params.getNomePaziente())){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByNomePaziente(params.getNomePaziente());
        }
        if(StringUtils.hasLength(params.getCognomePaziente())){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByCognomePaziente(params.getCognomePaziente());
        }
        if(StringUtils.hasLength(params.getNomeInfermiere())){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByNomeInfermiere(params.getNomeInfermiere());
        }
        if(StringUtils.hasLength(params.getCognomeInfermiere())){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByCognomeInfermiere(params.getCognomeInfermiere());
        }
        if(StringUtils.hasLength(params.getNomeVisita())){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByNomeVisita(params.getNomeInfermiere());
        }

        return visitaSottoministrazioneInfermiereList;
    }

    private List<VisitaSottoministrazioneInfermiere> findMedicinaleSottoministrazioneById(FiltraVisiteSottoministrateInfermieriParams params) {
        List<VisitaSottoministrazioneInfermiere> visitaSottoministrazioneInfermiereList = new ArrayList<>();
        if(params.getIdVisita()!=null){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByIdVisita(params.getIdVisita());
        }
        if(params.getIdSottoministrazione()!=null){
            visitaSottoministrazioneInfermiereList = Arrays.asList(visitaSottoministrazioneInfermiereRepository.findById(params.getIdSottoministrazione()).get());
        }
        if(params.getIdInfermiere()!=null){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByIdInfemiere(params.getIdInfermiere());
        }
        if(params.getIdCartellaClinica()!=null){
            visitaSottoministrazioneInfermiereList = visitaSottoministrazioneInfermiereRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        }
        return visitaSottoministrazioneInfermiereList;
    }

    private void checkParams(FiltraVisiteSottoministrateInfermieriParams params) {
        boolean verifyId = params.getIdVisita()==null && params.getIdSottoministrazione()==null && params.getIdInfermiere()==null
                && params.getIdCartellaClinica()==null;
        boolean verifyString = params.getCognomeInfermiere()==null && params.getNomeInfermiere()==null && params.getNomeVisita()==null &&
                params.getNomePaziente()==null && params.getCognomePaziente()==null;
        if(verifyId && verifyString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllVisiteSottoministrateInfermieriFiltrate");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public VisitaSottoministrazioneInfermiereDto somministraVisita(SomministraVisitaParams params) {
        checkParams(params);

        Optional<VisitaMedica> findVisitaMedica = visitaMedicaRepository.findById(params.getIdVisita());
        Optional<Infermiere> findInfermiere = infermiereRepository.findById(params.getIdInfermiere());
        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());

        boolean oneEmpty = findVisitaMedica.isEmpty() || findInfermiere.isEmpty() || findCartellaClinica.isEmpty();
        boolean allEmpty = findVisitaMedica.isEmpty() && findInfermiere.isEmpty() && findCartellaClinica.isEmpty();

        if(oneEmpty || allEmpty){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Uno o più oggetti non trovati.").build());
            esitoMessaggiRequestContextHolder.setOperationId("somministraVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        VisitaSottoministrazioneInfermiere visitaSottoministrazioneInfermiere = new VisitaSottoministrazioneInfermiere();

        visitaSottoministrazioneInfermiere.setVisitaMedica(findVisitaMedica.get());
        visitaSottoministrazioneInfermiere.setInfermiere(findInfermiere.get());
        visitaSottoministrazioneInfermiere.setCartellaClinica(findCartellaClinica.get());

        return VisitaSottoministrazioneInfermiereDtoMapper.INSTANCE.toDto(visitaSottoministrazioneInfermiereRepository.save(visitaSottoministrazioneInfermiere));
    }

    private void checkParams(SomministraVisitaParams params) {
        if(params.getIdVisita()==null && params.getIdInfermiere()==null && params.getIdCartellaClinica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire i parametri corettamente.").build());
            esitoMessaggiRequestContextHolder.setOperationId("somministraVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
