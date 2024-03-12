package com.mspaziente.service;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.dto.operazione.RefertoOperazioneDto;
import com.mspaziente.dto.output.CartellaClinicaOutputDto;
import com.mspaziente.dto.params.creazionecartellaclinica.*;
import com.mspaziente.dto.relationentities.*;
import com.mspaziente.dto.visitamedica.RefertoVisitaMedicaDto;
import com.mspaziente.entity.*;
import com.mspaziente.entity.operazione.OperazioneMedica;
import com.mspaziente.entity.operazione.RefertoOperazione;
import com.mspaziente.entity.relationentities.*;
import com.mspaziente.entity.visitamedica.RefertoVisitaMedica;
import com.mspaziente.entity.visitamedica.VisitaMedica;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.esito.Messaggio;
import com.mspaziente.esito.constants.EsitoOperazioneEnum;
import com.mspaziente.esito.constants.SeveritaMessaggioEnum;
import com.mspaziente.exception.EsitoRuntimeException;
import com.mspaziente.mapper.cartellaclinica.CartellaClinicaDtoMapper;
import com.mspaziente.mapper.cartellaclinica.CartellaClinicaEntityMapper;
import com.mspaziente.mapper.diagnosi.DiagnosiDtoMapper;
import com.mspaziente.mapper.diagnosi.DiagnosiEntityMapper;
import com.mspaziente.mapper.malattia.MalattiaDtoMapper;
import com.mspaziente.mapper.medicinale.MedicinaleDtoMapper;
import com.mspaziente.mapper.operazione.refertooperazione.RefertoOperazioneDtoMapper;
import com.mspaziente.mapper.relationentities.malattiacartella.MalattiaCartellaDtoMapper;
import com.mspaziente.mapper.relationentities.malattiacartella.MalattiaCartellaEntityMapper;
import com.mspaziente.mapper.relationentities.medicinalecartella.MedicinaleCartellaDtoMapper;
import com.mspaziente.mapper.relationentities.medicinalecartella.MedicinaleCartellaEntityMapper;
import com.mspaziente.mapper.relationentities.medicinaleprescrizione.MedicinalePrescrizioneDtoMapper;
import com.mspaziente.mapper.relationentities.medicinalesottoministrazione.MedicinaleSottoministrazioneDtoMapper;
import com.mspaziente.mapper.relationentities.operazionecartella.OperazioneCartellaDtoMapper;
import com.mspaziente.mapper.relationentities.operazioneprescrizione.OperazionePrescrizioneDtoMapper;
import com.mspaziente.mapper.relationentities.visitamedicacartella.VisitaMedicaCartellaDtoMapper;
import com.mspaziente.mapper.relationentities.visitaprescrizione.VisitaPrescrizioneDtoMapper;
import com.mspaziente.mapper.relationentities.visitasottoministrazioneinfermiere.VisitaSottoministrazioneInfermiereDtoMapper;
import com.mspaziente.mapper.relationentities.visitasottoministrazionemedico.VisitaSottoministrazioneMedicoDtoMapper;
import com.mspaziente.mapper.visitamedica.refertovisitamedica.RefertoVisitaMedicaDtoMapper;
import com.mspaziente.repository.*;
import com.mspaziente.repository.operazione.OperazioneMedicaRepository;
import com.mspaziente.repository.operazione.RefertoOperazioneRepository;
import com.mspaziente.repository.relationentities.*;
import com.mspaziente.repository.visitamedica.RefertoVisitaMedicaRepository;
import com.mspaziente.repository.visitamedica.VisitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class OperazioniSpecificheService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private DiagnosiRepository diagnosiRepository;
    @Autowired
    private MedicinalePrescrizioneRepository medicinalePrescrizioneRepository;
    @Autowired
    private MalattiaCartellaRepository malattiaCartellaRepository;
    @Autowired
    private MedicinaleCartellaRepository medicinaleCartellaRepository;
    @Autowired
    private MedicinaleSottoministrazioneRepository medicinaleSottoministrazioneRepository;
    @Autowired
    private OperazioneCartellaRepository operazioneCartellaRepository;
    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private CartellaClinicaRepository cartellaClinicaRepository;
    @Autowired
    private MalattiaRepository malattiaRepository;
    @Autowired
    private MedicinaleRepository medicinaleRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private VisitaMedicaRepository visitaMedicaRepository;
    @Autowired
    private InfermiereRepository infermiereRepository;
    @Autowired
    private OperazioneMedicaRepository operazioneMedicaRepository;
    @Autowired
    private RefertoOperazioneRepository refertoOperazioneRepository;
    @Autowired
    private OperazionePrescrizioneRepository operazionePrescrizioneRepository;
    @Autowired
    private RefertoVisitaMedicaRepository refertoVisitaMedicaRepository;
    @Autowired
    private VisitaMedicaCartellaRepository visitaMedicaCartellaRepository;
    @Autowired
    private VisitaPrescrizioneRepository visitaPrescrizioneRepository;
    @Autowired
    private VisitaSottoministrazioneInfermiereRepository visitaSottoministrazioneInfermiereRepository;
    @Autowired
    private VisitaSottoministrazioneMedicoRepository visitaSottoministrazioneMedicoRepository;

    public CartellaClinicaOutputDto findCartellaClinica(FindCartellaClinicaParams params) {
        checkParams(params);
        CartellaClinicaOutputDto cartellaClinicaDto = null;
        Integer idCartellaClinica = null;

        Optional<Paziente> findPaziente = Optional.empty();
        if(params.getIdPaziente()!=null){
            findPaziente = pazienteRepository.findById(params.getIdPaziente());
            if(findPaziente.isPresent()){
                idCartellaClinica = findPaziente.get().getCartellaClinica().getIdCartellaClinica();
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Nessun paziente trovato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("findCartellaClinica");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }
        if(idCartellaClinica==null){
            idCartellaClinica = params.getIdCartellaClinica();
        }

        List<Diagnosi> diagnosiList = diagnosiRepository.findByIdCartellaClinica(idCartellaClinica);
        if(!diagnosiList.isEmpty()){
            List<DiagnosiDto> diagnosiDto = DiagnosiDtoMapper.INSTANCE.toDto(diagnosiList);
            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setDiagnosi(diagnosiDto);
            }else{
                cartellaClinicaDto.setDiagnosi(diagnosiDto);
            }
        }

        List<MalattiaCartella> malattiaCartellaList = malattiaCartellaRepository.findByIdCartellaClinica(idCartellaClinica);

        if(!malattiaCartellaList.isEmpty()){
            List<MalattiaCartellaDto> malattiaCartellaDto = MalattiaCartellaDtoMapper.INSTANCE.toDto(malattiaCartellaList);
            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMalattie(malattiaCartellaDto);
            }else{
                cartellaClinicaDto.setMalattie(malattiaCartellaDto);
            }
        }

        List<MedicinaleCartella> medicinaleCartellaList = medicinaleCartellaRepository.findByIdCartellaClinica(idCartellaClinica);
        if(!medicinaleCartellaList.isEmpty()){
            List<MedicinaleCartellaDto> medicinaleCartellaDto = MedicinaleCartellaDtoMapper.INSTANCE.toDto(medicinaleCartellaList);
            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMedicinali(medicinaleCartellaDto);
            }else{
                cartellaClinicaDto.setMedicinali(medicinaleCartellaDto);
            }
        }

        List<MedicinalePrescrizione> medicinalePrescrizioneList = medicinalePrescrizioneRepository.findByIdCartellaClinica(idCartellaClinica);
        if(!medicinalePrescrizioneList.isEmpty()){
            List<MedicinalePrescrizioneDto> medicinalePrescrizioneDto = MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(medicinalePrescrizioneList);

            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMedicinaliPrescritti(medicinalePrescrizioneDto);
            }else{
                cartellaClinicaDto.setMedicinaliPrescritti(medicinalePrescrizioneDto);
            }
        }

        List<MedicinaleSottoministrazione> medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByIdCartellaClinica(idCartellaClinica);
        if(!medicinaleSottoministrazioneList.isEmpty()){
            List<MedicinaleSottoministrazioneDto> medicinalePrescrizioneDto = MedicinaleSottoministrazioneDtoMapper.INSTANCE.toDto(medicinaleSottoministrazioneList);

            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMedicinaliSottoministrti(medicinalePrescrizioneDto);
            }else{
                cartellaClinicaDto.setMedicinaliSottoministrti(medicinalePrescrizioneDto);
            }
        }

        List<OperazioneCartella> operazioneCartellaList = operazioneCartellaRepository.findByIdCartellaClinica(idCartellaClinica);
        if(!medicinaleSottoministrazioneList.isEmpty()){
            List<OperazioneCartellaDto> operazioneCartellaDto = OperazioneCartellaDtoMapper.INSTANCE.toDto(operazioneCartellaList);

            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setOperazioni(operazioneCartellaDto);
            }else{
                cartellaClinicaDto.setOperazioni(operazioneCartellaDto);
            }
        }
        if(cartellaClinicaDto!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("findCartellaClinica");
            return cartellaClinicaDto;
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findCartellaClinica");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

    }

    private void checkParams(FindCartellaClinicaParams params) {
        if(params.getIdCartellaClinica() == null && params.getIdPaziente()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno unn parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findCartellaClinica");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

    }

    public CartellaClinicaDto aggiungiCartellaClinica(AggiungiCartellaClinicaParams params) {
        checkParams(params);
        Optional<Paziente> findPaziente = pazienteRepository.findById(params.getIdPaziente());
        if(findPaziente.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Paziente non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiCartellaClinica");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        if(findPaziente.get().getCartellaClinica().getIdCartellaClinica()!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Il paziente selezionato ha già una cartella clinica associata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiCartellaClinica");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        CartellaClinicaDto cartellaClinicaSave = new CartellaClinicaDto();
        cartellaClinicaSave.setGruppoSanguigno(params.getGruppoSanguigno());
        cartellaClinicaSave = CartellaClinicaDtoMapper.INSTANCE.toDto(cartellaClinicaRepository.save(CartellaClinicaEntityMapper.INSTANCE.toEntity(cartellaClinicaSave)));

        findPaziente.get().getCartellaClinica().setIdCartellaClinica(cartellaClinicaSave.getIdCartellaClinica());
        pazienteRepository.save(findPaziente.get());

        return cartellaClinicaSave;
    }

    private void checkParams(AggiungiCartellaClinicaParams params) {
        if(params.getIdPaziente()==null && params.getGruppoSanguigno().isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire entrambi i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiCartellaClinica");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public DiagnosiDto aggiungiDiagnosi(AggiuntaDiagnosiParams params) {
        checkParams(params);

        Optional<CartellaClinica> findCartella = cartellaClinicaRepository.findById(params.getIdCartellaClinica());

        if(findCartella.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiDiagnosi");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        DiagnosiDto diagnosiDto = new DiagnosiDto();
        diagnosiDto.setCartellaClinica(CartellaClinicaDtoMapper.INSTANCE.toDto(findCartella.get()));
        diagnosiDto.setTipoDiagnosi(params.getTipoDiagnosi());
        diagnosiDto.setDescrizione(params.getDescrizione());

        try{
            DiagnosiDto diagnosiSave = DiagnosiDtoMapper.INSTANCE.toDto(diagnosiRepository.save(DiagnosiEntityMapper.INSTANCE.toEntity(diagnosiDto)));
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiDiagnosi");
            return diagnosiSave;
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica salvata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiDiagnosi");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiuntaDiagnosiParams params) {
        if(params.getIdCartellaClinica()==null && !StringUtils.hasLength(params.getDescrizione()) && !StringUtils.hasLength(params.getTipoDiagnosi())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiDiagnosi");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public MalattiaCartellaDto aggiungiMalattia(AggiungiMalattiaParams params) {
        checkParams(params);
        Optional<CartellaClinica> findCartella = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartella.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMalattia");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Malattia> findMalattia = malattiaRepository.findById(params.getIdMalattia());
        if(findMalattia.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna malattia  trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiDiagnosi");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        MalattiaCartellaDto malattiaCartellaToSave = new MalattiaCartellaDto();

        malattiaCartellaToSave.setMalattia(MalattiaDtoMapper.INSTANCE.toDto(findMalattia.get()));
        malattiaCartellaToSave.setCartellaClinica(CartellaClinicaDtoMapper.INSTANCE.toDto(findCartella.get()));

        try {
            malattiaCartellaToSave = MalattiaCartellaDtoMapper.INSTANCE.toDto(
                    malattiaCartellaRepository.save(MalattiaCartellaEntityMapper.INSTANCE.toEntity(malattiaCartellaToSave)));
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiDiagnosi");
            return malattiaCartellaToSave;
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna malattia salvata nella cartella.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMalattia");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiMalattiaParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdMalattia()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMalattia");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public MedicinaleCartellaDto aggiungiMedicinale(AggiungiMedicinaleParams params) {
        checkParams(params);
        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());

        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medicinale> findMedicinale = medicinaleRepository.findById(params.getIdMedicinale());

        if(findMedicinale.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medicinale trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        MedicinaleCartellaDto medicinaleCartellaToSave = new MedicinaleCartellaDto();
        medicinaleCartellaToSave.setMedicinale(MedicinaleDtoMapper.INSTANCE.toDto(findMedicinale.get()));
        medicinaleCartellaToSave.setCartellaClinica(CartellaClinicaDtoMapper.INSTANCE.toDto(findCartellaClinica.get()));

        try {
            medicinaleCartellaToSave = MedicinaleCartellaDtoMapper.INSTANCE.toDto(
                    medicinaleCartellaRepository.save(MedicinaleCartellaEntityMapper.INSTANCE.toEntity(medicinaleCartellaToSave)));
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinale");
            return medicinaleCartellaToSave;
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medicinale salvato nella cartella.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiMedicinaleParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdMedicinale()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public MedicinalePrescrizioneDto aggiungiPrescrizioneMedicinale(AggiungiPrescrizioneMedicinaleParams params) {
        checkParams(params);

        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medicinale> findMedicinale = medicinaleRepository.findById(params.getIdMedicinale());
        if(findMedicinale.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medicinale trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medico> findMedico = medicoRepository.findById(params.getIdMedico());
        if(findMedico.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<VisitaMedica> findVisitaMedica = visitaMedicaRepository.findById(params.getIdVisita());
        if(findVisitaMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita medica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        MedicinalePrescrizione medicinalePrescrizione = new MedicinalePrescrizione();
        medicinalePrescrizione.setMedicinale(findMedicinale.get());
        medicinalePrescrizione.setCartellaClinica(findCartellaClinica.get());
        medicinalePrescrizione.setMedico(findMedico.get());
        medicinalePrescrizione.setVisitaMedica(findVisitaMedica.get());

        try{
            return MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(medicinalePrescrizioneRepository.save(medicinalePrescrizione));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna prescrizione medicinale salvata nella cartella.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiPrescrizioneMedicinaleParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdMedicinale()==null && params.getIdMedico()==null && params.getIdVisita()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public MedicinaleSottoministrazioneDto aggiungiMedicinalePrescrizione(AggiungiMedicinaleSottoministrazioneParams params) {
        checkParams(params);
        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinalePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medicinale> findMedicinale = medicinaleRepository.findById(params.getIdMedicinale());
        if(findMedicinale.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medicinale trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinalePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Infermiere> findInfermiere = infermiereRepository.findById(params.getIdInfermiere());
        if(findInfermiere.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun infermiere trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinalePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        MedicinaleSottoministrazione medicinaleSottoministrazione = new MedicinaleSottoministrazione();
        medicinaleSottoministrazione.setMedicinale(findMedicinale.get());
        medicinaleSottoministrazione.setCartellaClinica(findCartellaClinica.get());
        medicinaleSottoministrazione.setInfermiere(findInfermiere.get());

        try {
            return MedicinaleSottoministrazioneDtoMapper.INSTANCE.toDto(medicinaleSottoministrazioneRepository.save(medicinaleSottoministrazione));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna sottomonistrazione medicinale salvata nella cartella.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneMedicinale");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiMedicinaleSottoministrazioneParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdMedicinale()==null && params.getIdInfermiere()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinalePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public OperazioneCartellaDto aggiungiOperazione(AggiungiOperazioneCartellaParams params) {
        checkParams(params);
        Optional<OperazioneMedica> findOperazioneMedica = operazioneMedicaRepository.findById(params.getIdOperazioneMedica());
        if(findOperazioneMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione medica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medico> findMedico = medicoRepository.findById(params.getIdMedico());
        if(findMedico.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<RefertoOperazione> findRefertoOperazione = refertoOperazioneRepository.findById(params.getIdReferoOperazione());
        if(findRefertoOperazione.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun referto operazione trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        OperazioneCartella operazioneCartellaSave = new OperazioneCartella();
        operazioneCartellaSave.setOperazioneMedica(findOperazioneMedica.get());
        operazioneCartellaSave.setCartellaClinica(findCartellaClinica.get());
        operazioneCartellaSave.setMedico(findMedico.get());
        operazioneCartellaSave.setRefertoOperazione(findRefertoOperazione.get());

        try{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazione");
            return OperazioneCartellaDtoMapper.INSTANCE.toDto(operazioneCartellaRepository.save(operazioneCartellaSave));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione salvata nella cartella.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazione");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private void checkParams(AggiungiOperazioneCartellaParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdOperazioneMedica()==null && params.getIdMedico()==null && params.getIdReferoOperazione()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiMedicinalePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public RefertoOperazioneDto aggiungiRefertoOperazione(AggiungiRefertoOperazioneParams params) {
        checkParams(params);
        RefertoOperazione refertoOperazione = new RefertoOperazione();
        refertoOperazione.setTipologia(params.getTipologia());
        refertoOperazione.setDescrizione(params.getDescrizione());
        refertoOperazione.setDataReferto(params.getDataReferto());
        try {
            return RefertoOperazioneDtoMapper.INSTANCE.toDto(refertoOperazioneRepository.save(refertoOperazione));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun referto operazione salvato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiRefertoOperazione");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiRefertoOperazioneParams params) {
        if(!StringUtils.hasLength(params.getTipologia()) && !StringUtils.hasLength(params.getDescrizione()) && !StringUtils.hasLength(params.getDataReferto())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiRefertoOperazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public OperazionePrescrizioneDto aggiungiOperazionePrescrizione(AggiuntaOperazionePrescrizioneParams params) {
        checkParams(params);
        Optional<OperazioneMedica> findOperazioneMedica = operazioneMedicaRepository.findById(params.getIdOperazione());
        if(findOperazioneMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione medica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartella());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medico> findMedico = medicoRepository.findById(params.getIdMedico());
        if(findMedico.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        OperazionePrescrizione operazionePrescrizioneSave = new OperazionePrescrizione();
        operazionePrescrizioneSave.setMedico(findMedico.get());
        operazionePrescrizioneSave.setCartellaClinica(findCartellaClinica.get());
        operazionePrescrizioneSave.setOperazioneMedica(findOperazioneMedica.get());

        try{
            return OperazionePrescrizioneDtoMapper.INSTANCE.toDto(operazionePrescrizioneRepository.save(operazionePrescrizioneSave));
        }catch(Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione prescrizione salvata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private void checkParams(AggiuntaOperazionePrescrizioneParams params) {
        if(params.getIdMedico()==null && params.getIdCartella()==null & params.getIdOperazione()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public VisitaMedicaCartellaDto aggiungiVisitaMedica(AggiungiVisitaMedicaCartellaParams params) {
        checkParams(params);
        Optional<VisitaMedica> findVisitaMedica = visitaMedicaRepository.findById(params.getIdVisitaMedica());
        if(findVisitaMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita medica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<RefertoVisitaMedica> findRefertoVisitaMedica = refertoVisitaMedicaRepository.findById(params.getIdReferto());
        if(findRefertoVisitaMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        VisitaMedicaCartella visitaMedicaCartella = new VisitaMedicaCartella();
        visitaMedicaCartella.setVisitaMedica(findVisitaMedica.get());
        visitaMedicaCartella.setRefertoVisitaMedica(findRefertoVisitaMedica.get());
        visitaMedicaCartella.setCartellaClinica(findCartellaClinica.get());

        try{
            return VisitaMedicaCartellaDtoMapper.INSTANCE.toDto(visitaMedicaCartellaRepository.save(visitaMedicaCartella));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita medica salvata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiVisitaMedica");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiVisitaMedicaCartellaParams params) {
        if(params.getIdVisitaMedica()==null && params.getIdCartellaClinica()==null & params.getIdCartellaClinica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiOperazionePrescrizione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public RefertoVisitaMedicaDto aggiungiRefertoVisitaMedica(AggiungiRefertoVisitaMedicaParams params) {
        checkParams(params);

        RefertoVisitaMedica refertoVisitaMedica = new RefertoVisitaMedica();
        refertoVisitaMedica.setDataReferto(params.getDataReferto());
        refertoVisitaMedica.setTipologia(params.getTipologia());
        refertoVisitaMedica.setDescrizione(params.getDescrizione());

        try {
            return RefertoVisitaMedicaDtoMapper.INSTANCE.toDto(refertoVisitaMedicaRepository.save(refertoVisitaMedica));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione prescrizione salvata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiRefertoVisitaMedica");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiRefertoVisitaMedicaParams params) {
        if(params.getDescrizione()==null && params.getDataReferto()==null & params.getTipologia()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiRefertoVisitaMedica");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public VisitaPrescrizioneDto aggiungiPrescrizioneVisita(AggiungiVisitaPrescrizioneParams params) {
        checkParams(params);
        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medico> findMedico = medicoRepository.findById(params.getIdMedico());
        if(findMedico.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<VisitaMedica> findVisitaMedica = visitaMedicaRepository.findById(params.getIdVisita());
        if(findVisitaMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita medica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        VisitaPrescrizione visitaPrescrizioneSave = new VisitaPrescrizione();

        visitaPrescrizioneSave.setCartellaClinica(findCartellaClinica.get());
        visitaPrescrizioneSave.setMedico(findMedico.get());
        visitaPrescrizioneSave.setVisitaMedica(findVisitaMedica.get());

        try {
            return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(visitaPrescrizioneRepository.save(visitaPrescrizioneSave));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita prescrizione salvata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiVisitaPrescrizioneParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdVisita()==null && params.getIdMedico()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public VisitaSottoministrazioneInfermiereDto aggiungiVisitaSottoministrazioneInfermiere(AggiungiVisitaSottoministrazioneInfermiereParams params) {
        checkParams(params);

        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiVisitaSottoministrazioneInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<VisitaMedica> findVisitaMedica = visitaMedicaRepository.findById(params.getIdVisita());
        if(findVisitaMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita medica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiVisitaSottoministrazioneInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Infermiere> findInfermiere = infermiereRepository.findById(params.getIdInfermiere());
        if(findInfermiere.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun infermiere trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiVisitaSottoministrazioneInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        VisitaSottoministrazioneInfermiere visitaSottoministrazioneInfermiere = new VisitaSottoministrazioneInfermiere();
        visitaSottoministrazioneInfermiere.setCartellaClinica(findCartellaClinica.get());
        visitaSottoministrazioneInfermiere.setVisitaMedica(findVisitaMedica.get());
        visitaSottoministrazioneInfermiere.setInfermiere(findInfermiere.get());

        try {
            return VisitaSottoministrazioneInfermiereDtoMapper.INSTANCE.toDto(visitaSottoministrazioneInfermiereRepository.save(visitaSottoministrazioneInfermiere));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita sottoministrazione salvata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiVisitaSottoministrazioneInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiVisitaSottoministrazioneInfermiereParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdVisita()==null && params.getIdInfermiere()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiVisitaSottoministrazioneInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public VisitaSottoministrazioneMedicoDto aggiungiVisitaSottoministrazioneMedico(AggiungiVisitaSottoministrazioneMedicoParams params) {
        checkParams(params);
        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        if(findCartellaClinica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna cartella clinica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medico> findMedico = medicoRepository.findById(params.getIdMedico());
        if(findMedico.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<VisitaMedica> findVisitaMedica = visitaMedicaRepository.findById(params.getIdVisita());
        if(findVisitaMedica.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita medica trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        VisitaSottoministrazioneMedico visitaSottoministrazioneMedico = new VisitaSottoministrazioneMedico();
        visitaSottoministrazioneMedico.setMedico(findMedico.get());
        visitaSottoministrazioneMedico.setCartellaClinica(findCartellaClinica.get());
        visitaSottoministrazioneMedico.setVisitaMedica(findVisitaMedica.get());

        try {
            return VisitaSottoministrazioneMedicoDtoMapper.INSTANCE.toDto(visitaSottoministrazioneMedicoRepository.save(visitaSottoministrazioneMedico));
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna visita sottoministrazione da parte di un medico salvata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiVisitaSottoministrazioneMedico");
            throw  new EsitoRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void checkParams(AggiungiVisitaSottoministrazioneMedicoParams params) {
        if(params.getIdCartellaClinica()==null && params.getIdVisita()==null && params.getIdMedico()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiungiPrescrizioneVisita");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
