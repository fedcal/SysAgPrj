package com.msinfermiere.service;

import com.msinfermiere.dto.params.medicinaleoperazioni.FiltraMedicinalePrescrizioniParams;
import com.msinfermiere.dto.params.medicinaleoperazioni.FiltraMedicinaliSottoministrazioneParams;
import com.msinfermiere.dto.params.medicinaleoperazioni.SomministraMedicinaleParams;
import com.msinfermiere.dto.relationentities.MedicinalePrescrizioneDto;
import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.msinfermiere.entity.Infermiere;
import com.msinfermiere.entity.Medicinale;
import com.msinfermiere.entity.paziente.CartellaClinica;
import com.msinfermiere.entity.relationentites.MedicinalePrescrizione;
import com.msinfermiere.entity.relationentites.MedicinaleSottoministrazione;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.Messaggio;
import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import com.msinfermiere.esito.constants.SeveritaMessaggioEnum;
import com.msinfermiere.exception.EsitoRuntimeException;
import com.msinfermiere.mapper.relationentities.medicinaleprescrizione.MedicinalePrescrizioneDtoMapper;
import com.msinfermiere.mapper.relationentities.medicinalesottoministrazione.MedicinaleSottoministrazioneDtoMapper;
import com.msinfermiere.repository.InfermiereRepository;
import com.msinfermiere.repository.MedicinaleRepository;
import com.msinfermiere.repository.paziente.CartellaClinicaRepository;
import com.msinfermiere.repository.relationentites.MedicinalePrescrizioneRepository;
import com.msinfermiere.repository.relationentites.MedicinaleSottoministrazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MedicinaleOperazioniService {
    @Autowired
    private MedicinalePrescrizioneRepository medicinalePrescrizioneRepository;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MedicinaleSottoministrazioneRepository medicinaleSottoministrazioneRepository;

    @Autowired
    private CartellaClinicaRepository cartellaClinicaRepository;

    @Autowired
    private InfermiereRepository infermiereRepository;

    @Autowired
    private MedicinaleRepository medicinaleRepository;

    public List<MedicinalePrescrizioneDto> getAllMedicinalePrescrizioni() {
        List<MedicinalePrescrizione> listaMedicinalePrescrizioni = medicinalePrescrizioneRepository.findAll();
        if(listaMedicinalePrescrizioni.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista prescrizioni medicinale ottenuta.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllMedicinalePrescrizioni");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getAllMedicinalePrescrizioni");
            return MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(listaMedicinalePrescrizioni);
        }
    }

    public List<MedicinalePrescrizioneDto> getPrescrizioniMedicinaliFiltrati(FiltraMedicinalePrescrizioniParams params) {
        checkParams(params);

        List<MedicinalePrescrizione> findById = findMedicinalePrescrizioneById(params);
        List<MedicinalePrescrizione> findByString = findMedicinalePrescrizioneByString(params);

        if(findByString!=null && findById!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna prescrizione medicinale.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPrescrizioniMedicinaliFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(findById!=null){
            return MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(findById);
        }
        if(findByString!=null){
            return MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(findByString);
        }
        return new ArrayList<>();
    }

    private List<MedicinalePrescrizione> findMedicinalePrescrizioneByString(FiltraMedicinalePrescrizioniParams params) {
        List<MedicinalePrescrizione> medicinalePrescrizione = new ArrayList<>();
        if(StringUtils.hasLength(params.getNomeMedicinale())){
            medicinalePrescrizione = medicinalePrescrizioneRepository.findByNomeMedicinale(params.getNomeMedicinale());
        }
        if(StringUtils.hasLength(params.getNomeMedico())&&StringUtils.hasLength(params.getCognomeMedico())){
            medicinalePrescrizione = medicinalePrescrizioneRepository.findByNomeAndCognomeMedico(params.getNomeMedico(),params.getCognomeMedico());
        }
        if(StringUtils.hasLength(params.getNomeMedico())){
            medicinalePrescrizione = medicinalePrescrizioneRepository.findByNomeMedico(params.getNomeMedico());
        }
        if(StringUtils.hasLength(params.getCognomeMedico())){
            medicinalePrescrizione = medicinalePrescrizioneRepository.findByCognomeMedico(params.getCognomeMedico());
        }
        return medicinalePrescrizione;
    }

    private List<MedicinalePrescrizione> findMedicinalePrescrizioneById(FiltraMedicinalePrescrizioniParams params) {
        List<MedicinalePrescrizione> medicinalePrescrizione = new ArrayList<>();
        if(params.getIdMedicinale()!=null){
            medicinalePrescrizione = medicinalePrescrizioneRepository.findByIdMedicinale(params.getIdMedicinale());
        }
        if(params.getIdPrescrizioneMedicinale()!=null){
            medicinalePrescrizione = Arrays.asList(medicinalePrescrizioneRepository.findById(params.getIdPrescrizioneMedicinale()).get());
        }
        if(params.getIdMedico()!=null){
            medicinalePrescrizione = medicinalePrescrizioneRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdCartellaClinica()!=null){
            medicinalePrescrizione = medicinalePrescrizioneRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        }
        return medicinalePrescrizione;
    }

    private void checkParams(FiltraMedicinalePrescrizioniParams params) {
        boolean verifyId = params.getIdMedicinale()==null && params.getIdPrescrizioneMedicinale()==null && params.getIdMedico()==null
                            && params.getIdCartellaClinica()==null;
        boolean verifyString = !StringUtils.hasLength(params.getCognomeMedico()) && !StringUtils.hasLength(params.getNomeMedico())
                                && !StringUtils.hasLength(params.getNomeMedicinale()) && !StringUtils.hasLength(params.getNomePaziente())
                                && !StringUtils.hasLength(params.getCognomePaziente());
        if(verifyId && verifyString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPrescrizioniMedicinaliFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<MedicinaleSottoministrazioneDto> getAllMedicinaleSottoministrazioni() {
        List<MedicinaleSottoministrazione> medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findAll();
        if(medicinaleSottoministrazioneList.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista prescrizioni medicinale ottenuta.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllMedicinaleSottoministrazioni");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getAllMedicinalePrescrizioni");
            return MedicinaleSottoministrazioneDtoMapper.INSTANCE.toDto(medicinaleSottoministrazioneList);
        }
    }

    public List<MedicinaleSottoministrazioneDto> getAllMedicinaleSottoministrazioniFiltrata(FiltraMedicinaliSottoministrazioneParams params) {
        checkParams(params);
        List<MedicinaleSottoministrazione> findById = findMedicinaleSottoministrazioneById(params);
        List<MedicinaleSottoministrazione> findByString = findMedicinaleSottoministrazioneByString(params);

        if(findByString!=null && findById!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna prescrizione medicinale.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPrescrizioniMedicinaliFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(findById!=null){
            return MedicinaleSottoministrazioneDtoMapper.INSTANCE.toDto(findById);
        }
        if(findByString!=null){
            return MedicinaleSottoministrazioneDtoMapper.INSTANCE.toDto(findByString);
        }
        return new ArrayList<>();
    }

    private List<MedicinaleSottoministrazione> findMedicinaleSottoministrazioneByString(FiltraMedicinaliSottoministrazioneParams params) {
        List<MedicinaleSottoministrazione> medicinaleSottoministrazioneList = new ArrayList<>();
        if(StringUtils.hasLength(params.getNomeMedicinale())){
            medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByNomeMedicinale(params.getNomeMedicinale());
        }
        if(StringUtils.hasLength(params.getNomeMedico())&&StringUtils.hasLength(params.getCognomeMedico())){
            medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByNomeAndCognomeMedico(params.getNomeMedico(),params.getCognomeMedico());
        }
        if(StringUtils.hasLength(params.getNomeMedico())){
            medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByNomeMedico(params.getNomeMedico());
        }
        if(StringUtils.hasLength(params.getCognomeMedico())){
            medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByCognomeMedico(params.getCognomeMedico());
        }
        return medicinaleSottoministrazioneList;
    }

    private List<MedicinaleSottoministrazione> findMedicinaleSottoministrazioneById(FiltraMedicinaliSottoministrazioneParams params) {
        List<MedicinaleSottoministrazione> medicinaleSottoministrazioneList = new ArrayList<>();
        if(params.getIdMedicinale()!=null){
            medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByIdMedicinale(params.getIdMedicinale());
        }
        if(params.getIdPrescrizioneMedicinale()!=null){
            medicinaleSottoministrazioneList = Arrays.asList(medicinaleSottoministrazioneRepository.findById(params.getIdPrescrizioneMedicinale()).get());
        }
        if(params.getIdMedico()!=null){
            medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdCartellaClinica()!=null){
            medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        }
        return medicinaleSottoministrazioneList;
    }

    private void checkParams(FiltraMedicinaliSottoministrazioneParams params) {
        boolean verifyId = params.getIdMedicinale()==null && params.getIdPrescrizioneMedicinale()==null && params.getIdMedico()==null
                && params.getIdCartellaClinica()==null;
        boolean verifyString = !StringUtils.hasLength(params.getCognomeMedico()) && !StringUtils.hasLength(params.getNomeMedico())
                && !StringUtils.hasLength(params.getNomeMedicinale()) && !StringUtils.hasLength(params.getNomePaziente())
                && !StringUtils.hasLength(params.getCognomePaziente());
        if(verifyId && verifyString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPrescrizioniMedicinaliFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public MedicinaleSottoministrazioneDto somministraMedicinale(SomministraMedicinaleParams params) {
        checkParams(params);
        Optional<Medicinale> medicinaleFind = medicinaleRepository.findById(params.getMedicinale());
        Optional<Infermiere> infermiereFind = infermiereRepository.findById(params.getInfermiere());
        Optional<CartellaClinica> cartellaClinicaFind = cartellaClinicaRepository.findById(params.getCartellaClinica());

        boolean oneEntityEmpty = medicinaleFind.isEmpty() || infermiereFind.isEmpty() || cartellaClinicaFind.isEmpty();
        boolean allEntityEmpty = medicinaleFind.isEmpty() && infermiereFind.isEmpty() && cartellaClinicaFind.isEmpty();

        if(oneEntityEmpty || allEntityEmpty){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPrescrizioniMedicinaliFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        MedicinaleSottoministrazione medicinaleSottoministrazione = new MedicinaleSottoministrazione();
        medicinaleSottoministrazione.setMedicinale(medicinaleFind.get());
        medicinaleSottoministrazione.setInfermiere(infermiereFind.get());
        medicinaleSottoministrazione.setCartellaClinica(cartellaClinicaFind.get());

        return MedicinaleSottoministrazioneDtoMapper.INSTANCE.toDto(medicinaleSottoministrazioneRepository.save(medicinaleSottoministrazione));
    }

    private void checkParams(SomministraMedicinaleParams params) {
        if(params.getMedicinale()==null && params.getInfermiere()==null && params.getCartellaClinica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("somministraMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
