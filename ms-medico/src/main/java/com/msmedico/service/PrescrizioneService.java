package com.msmedico.service;

import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleAddParams;
import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleInfoParams;
import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleModifyParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneAddParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneInfoParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneModifyParams;
import com.msmedico.dto.params.prescrizione.visita.PrescrizioneVisitaAddParams;
import com.msmedico.dto.params.prescrizione.visita.PrescrizioneVisitaInfoParams;
import com.msmedico.dto.params.prescrizione.visita.PrescrizioneVisitaModifyParams;
import com.msmedico.dto.relationentities.MedicinalePrescrizioneDto;
import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
import com.msmedico.dto.relationentities.VisitaPrescrizioneDto;
import com.msmedico.entity.Medicinale;
import com.msmedico.entity.Medico;
import com.msmedico.entity.operazione.OperazioneMedica;
import com.msmedico.entity.paziente.CartellaClinica;
import com.msmedico.entity.relationentities.MedicinalePrescrizione;
import com.msmedico.entity.relationentities.OperazionePrescrizione;
import com.msmedico.entity.relationentities.VisitaPrescrizione;
import com.msmedico.entity.visitamedica.VisitaMedica;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.Messaggio;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.exception.EsitoRuntimeException;
import com.msmedico.mapper.relationentities.medicinaleprescrizione.MedicinalePrescrizioneDtoMapper;
import com.msmedico.mapper.relationentities.operazioneprescrizione.OperazionePrescrizioneDtoMapper;
import com.msmedico.mapper.relationentities.visitaprescrizione.VisitaPrescrizioneDtoMapper;
import com.msmedico.repository.MedicinaleRepository;
import com.msmedico.repository.MedicoRepository;
import com.msmedico.repository.operazione.OperazioneMedicaRepository;
import com.msmedico.repository.paziente.CartellaClinicaRepository;
import com.msmedico.repository.relationentities.MedicinalePrescrizioneRepository;
import com.msmedico.repository.relationentities.OperazionePrescrizioneRepository;
import com.msmedico.repository.relationentities.VisitaPrescrizioneRepository;
import com.msmedico.repository.visitamedica.VisitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PrescrizioneService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private OperazionePrescrizioneRepository operazionePrescrizioneRepository;

    @Autowired
    private MedicinalePrescrizioneRepository medicinalePrescrizioneRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicinaleRepository medicinaleRepository;

    @Autowired
    private CartellaClinicaRepository cartellaClinicaRepository;

    @Autowired
    private OperazioneMedicaRepository operazioneMedicaRepository;

    @Autowired
    private VisitaPrescrizioneRepository visitaPrescrizioneRepository;

    @Autowired
    private VisitaMedicaRepository visitaMedicaRepository;

    public List<OperazionePrescrizioneDto> prescriviOperazioneInfo(PrescrizioneOperazioneInfoParams params) {
        checkParams(params);

        List<OperazionePrescrizione> operazionePrescrizioneByString = findOperazioneByString(params);

        if(operazionePrescrizioneByString.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneInfo");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return OperazionePrescrizioneDtoMapper.INSTANCE.toDto(operazionePrescrizioneByString);
        }
    }

    private List<OperazionePrescrizione> findOperazioneByString(PrescrizioneOperazioneInfoParams params) {
        if(params.getCognomePaziente()!=null && params.getNomePaziente()!=null){
            return operazionePrescrizioneRepository.findByNomeAndCognomePaziente(params.getNomePaziente(),params.getCognomePaziente());
        }
        if(params.getCognomeMedico()!=null && params.getNomeMedico()!=null){
            return operazionePrescrizioneRepository.findByNomeAndCognomeMedico(params.getNomeMedico(),params.getCognomeMedico());
        }
        if (params.getNomeOperazione()!=null){
            return operazionePrescrizioneRepository.findByNomeOperazione(params.getNomeOperazione());
        }
        if(params.getCognomePaziente()!=null){
            return operazionePrescrizioneRepository.findByCognomePaziente(params.getCognomePaziente());
        }
        if(params.getNomePaziente()!=null){
            return operazionePrescrizioneRepository.findByNomePaziente(params.getNomePaziente());
        }
        if(params.getCognomeMedico()!=null){
            return operazionePrescrizioneRepository.findByCognomeMedico(params.getCognomeMedico());
        }
        if(params.getNomeMedico()!=null){
            return operazionePrescrizioneRepository.findByNomeMedico(params.getNomeMedico());
        }
        if (params.getIdOperazione()!=null){
            return operazionePrescrizioneRepository.findByIdOperazione(params.getIdOperazione());
        }
        if(params.getIdMedico()!=null){
            return operazionePrescrizioneRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdCartella()!=null){
            return operazionePrescrizioneRepository.findByIdCartella(params.getIdCartella());
        }
        if(params.getIdPaziente()!=null){
            return operazionePrescrizioneRepository.findByIdPaziente(params.getIdPaziente());
        }
        return new ArrayList<>();
    }

    private void checkParams(PrescrizioneOperazioneInfoParams params) {
        boolean checkId = params.getIdCartella()==null && params.getIdMedico()==null && params.getIdOperazione()==null &&
                params.getIdPaziente()==null;
        boolean checkString = params.getNomeMedico()==null && params.getCognomeMedico()!=null && params.getNomePaziente()==null
                && params.getCognomePaziente()==null && params.getNomeOperazione()==null;
        if(checkId && checkString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneInfo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public OperazionePrescrizioneDto prescriviOperazioneAdd(PrescrizioneOperazioneAddParams params) {
        checkParams(params);
        OperazionePrescrizione operazionePrescrizioneSave = new OperazionePrescrizione();
        operazionePrescrizioneSave.setMedico(medicoRepository.findById(params.getMedico()).get());
        operazionePrescrizioneSave.setCartellaClinica(cartellaClinicaRepository.findById(params.getMedico()).get());
        operazionePrescrizioneSave.setOperazioneMedica(operazioneMedicaRepository.findById(params.getMedico()).get());
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        return  OperazionePrescrizioneDtoMapper.INSTANCE.toDto(operazionePrescrizioneRepository.save(operazionePrescrizioneSave));
    }

    private void checkParams(PrescrizioneOperazioneAddParams params) {
        if(params.getMedico()==null || params.getCartellaClinica()==null || params.getOperazioneMedica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneAdd");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        Optional<Medico> findMedico = medicoRepository.findById(params.getMedico());
        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getCartellaClinica());
        Optional<OperazioneMedica> findOperazioneMedica = operazioneMedicaRepository.findById(params.getOperazioneMedica());
        if(!findMedico.isPresent() || !findCartellaClinica.isPresent() || !findOperazioneMedica.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire correttamente i parametri di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneAdd");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public OperazionePrescrizioneDto prescriviOperazioneModify(PrescrizioneOperazioneModifyParams params) {
        checkParams(params);
        Optional<OperazionePrescrizione> findOperazionePrescrizione = operazionePrescrizioneRepository.findById(params.getIdRelazione());
        Optional<Medico> findMedico = Optional.empty();
        Optional<CartellaClinica> findCartellaClinica = Optional.empty();
        Optional<OperazioneMedica> findOperazioneMedica = Optional.empty();

        if(params.getNuovoMedico()!=null){
            findMedico = medicoRepository.findById(params.getNuovoMedico());
        }
        if(params.getNuovoMedico()!=null){
            findCartellaClinica = cartellaClinicaRepository.findById(params.getNuovaCartellaClinica());
        }
        if(params.getNuovoMedico()!=null){
            findOperazioneMedica = operazioneMedicaRepository.findById(params.getNuovaOperazioneMedica());
        }

        findOperazionePrescrizione.get().setMedico(findMedico.get());
        findOperazionePrescrizione.get().setCartellaClinica(findCartellaClinica.get());
        findOperazionePrescrizione.get().setOperazioneMedica(findOperazioneMedica.get());
        operazionePrescrizioneRepository.save(findOperazionePrescrizione.get());

        return OperazionePrescrizioneDtoMapper.INSTANCE.toDto(findOperazionePrescrizione.get());
    }

    private void checkParams(PrescrizioneOperazioneModifyParams params) {
        if(params.getIdRelazione()==null || params.getNuovoMedico()==null || params.getNuovaOperazioneMedica()==null
        || params.getNuovaCartellaClinica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno due parametri di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneModify");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        List<OperazionePrescrizione> findOperazionePrescrizione = new ArrayList<>();
        Optional<Medico> findMedico = Optional.empty();
        Optional<CartellaClinica> findCartellaClinica = Optional.empty();
        Optional<OperazioneMedica> findOperazioneMedica = Optional.empty();

        if(params.getIdRelazione()!=null){
            findOperazionePrescrizione = operazionePrescrizioneRepository.findByIdOperazione(params.getIdRelazione());
        }

        if(params.getNuovoMedico()!=null){
            findMedico = medicoRepository.findById(params.getNuovoMedico());
        }
        if(params.getNuovoMedico()!=null){
            findCartellaClinica = cartellaClinicaRepository.findById(params.getNuovaCartellaClinica());
        }
        if(params.getNuovoMedico()!=null){
            findOperazioneMedica = operazioneMedicaRepository.findById(params.getNuovaOperazioneMedica());
        }


        if( (params.getIdRelazione()!=null && !findOperazionePrescrizione.isEmpty())
                || (params.getNuovoMedico()!=null && !findMedico.isPresent())
                || (params.getNuovaCartellaClinica()!=null && !findCartellaClinica.isPresent())
                || (params.getNuovaOperazioneMedica()!=null && !findOperazioneMedica.isPresent())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire correttamente i parametri di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneModify");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public String prescriviOperazioneDelete(Integer params) {
        if(params==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire correttamente i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneDelete");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if(!operazionePrescrizioneRepository.findById(params).isPresent()){
            try{
                operazionePrescrizioneRepository.delete(operazionePrescrizioneRepository.findById(params).get());
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                return "Prescrizione operazione eliminata";
            }catch (Exception e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Non è stato possibile eliminare la prescrizionne.").build());
                esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneDelete");
                throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Prescrizione non trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneDelete");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public List<MedicinalePrescrizioneDto> prescriviMedicinaleInfo(PrescrizioneMedicinaleInfoParams params) {
        checkParams(params);

        Optional<MedicinalePrescrizione> medicinalePrescrizioneById = findMedicinalePrescrizioneById(params);
        List<MedicinalePrescrizione> medicinalePrescrizioneByString = findMedicinalePrescrizioneByString(params);

        if(medicinalePrescrizioneById.isEmpty() && medicinalePrescrizioneByString.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneInfo");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        if(medicinalePrescrizioneById.isPresent()){
            List<MedicinalePrescrizioneDto> listaReturn = new ArrayList<>();
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            listaReturn.add(MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(medicinalePrescrizioneById.get()));
            return listaReturn;
        }

        if(!medicinalePrescrizioneByString.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(medicinalePrescrizioneByString);
        }

        return null;
    }

    private Optional<MedicinalePrescrizione> findMedicinalePrescrizioneById(PrescrizioneMedicinaleInfoParams params) {

        if(params.getIdRelazione()!=null){
            return medicinalePrescrizioneRepository.findById(params.getIdRelazione());
        }
        return Optional.empty();
    }

    private List<MedicinalePrescrizione> findMedicinalePrescrizioneByString(PrescrizioneMedicinaleInfoParams params) {
        if(params.getCognomePaziente()!=null && params.getNomePaziente()!=null){
            return medicinalePrescrizioneRepository.findByNomeAndCognomePaziente(params.getNomePaziente(),params.getCognomePaziente());
        }
        if(params.getCognomeMedico()!=null && params.getNomeMedico()!=null){
            return medicinalePrescrizioneRepository.findByNomeAndCognomeMedico(params.getNomeMedico(),params.getCognomeMedico());
        }
        if (params.getNomeMedicinale()!=null){
            return medicinalePrescrizioneRepository.findByNomeMedicinale(params.getNomeMedicinale());
        }
        if(params.getCognomePaziente()!=null){
            return medicinalePrescrizioneRepository.findByCognomePaziente(params.getCognomePaziente());
        }
        if(params.getNomePaziente()!=null){
            return medicinalePrescrizioneRepository.findByNomePaziente(params.getNomePaziente());
        }
        if(params.getCognomeMedico()!=null){
            return medicinalePrescrizioneRepository.findByCognomeMedico(params.getCognomeMedico());
        }
        if(params.getNomeMedico()!=null){
            return medicinalePrescrizioneRepository.findByNomeMedico(params.getNomeMedico());
        }
        if (params.getIdMedicinale()!=null){
            return medicinalePrescrizioneRepository.findByIdMedicinale(params.getIdMedicinale());
        }
        if(params.getIdCartellaClinica()!=null){
            return medicinalePrescrizioneRepository.findByIdCartella(params.getIdCartellaClinica());
        }
        if(params.getIdMedico()!=null){
            return medicinalePrescrizioneRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdPaziente()!=null){
            return medicinalePrescrizioneRepository.findByIdPaziente(params.getIdPaziente());
        }
        return new ArrayList<>();
    }

    private void checkParams(PrescrizioneMedicinaleInfoParams params) {
        boolean checkId = params.getIdMedico()==null && params.getIdMedicinale()==null &&
                params.getIdPaziente()==null && params.getIdCartellaClinica()==null && params.getIdRelazione()==null;
        boolean checkString = params.getNomeMedico()==null && params.getCognomeMedico()==null && params.getNomePaziente()==null
                && params.getCognomePaziente()==null && params.getNomeMedicinale()==null;
        if(checkId && checkString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleInfo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public String prescriviMedicinaleDelete(Integer params) {
        if(params==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire correttamente i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleDelete");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if(!medicinalePrescrizioneRepository.findById(params).isPresent()){
            try{
                medicinalePrescrizioneRepository.delete(medicinalePrescrizioneRepository.findById(params).get());
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                return "Prescrizione medicinale eliminata";
            }catch (Exception e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Non è stato possibile eliminare la prescrizionne.").build());
                esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleDelete");
                throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Prescrizione non trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleDelete");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public MedicinalePrescrizioneDto prescriviMedicinaleAdd(PrescrizioneMedicinaleAddParams params) {
        checkParams(params);

        Optional<Medicinale> findMedicinale = medicinaleRepository.findById(params.getIdMedicinale());
        Optional<CartellaClinica> findCartellaClinica = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        Optional<Medico> findMedico = medicoRepository.findById(params.getIdMedico());

        MedicinalePrescrizione medicinalePrescrizione = new MedicinalePrescrizione();
        medicinalePrescrizione.setMedicinale(findMedicinale.get());
        medicinalePrescrizione.setCartellaClinica(findCartellaClinica.get());
        medicinalePrescrizione.setMedico(findMedico.get());

        return MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(medicinalePrescrizioneRepository.save(medicinalePrescrizione));
    }

    private void checkParams(PrescrizioneMedicinaleAddParams params) {
        if(params.getIdMedico()==null && params.getIdMedicinale()==null &&
                params.getIdCartellaClinica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleAdd");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if( !medicinaleRepository.findById(params.getIdMedicinale()).isPresent()
            || !cartellaClinicaRepository.findById(params.getIdCartellaClinica()).isPresent()
            || !medicoRepository.findById(params.getIdMedico()).isPresent())   {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Non è stato trovato nessuna corrispondenza coon uno o più id inseriti.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleAdd");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

    }

    public MedicinalePrescrizioneDto prescriviMedicinaleModify(PrescrizioneMedicinaleModifyParams params) {
        checkParams(params);

        Optional<MedicinalePrescrizione> findMedicinalePrescrizione = medicinalePrescrizioneRepository.findById(params.getIdRelazione());

        if(params.getNuovoMedicinale()!=null){
            findMedicinalePrescrizione.get().setMedicinale(medicinaleRepository.findById(params.getNuovoMedicinale()).get());
        }
        if(params.getNuovoMedico()!=null){
            findMedicinalePrescrizione.get().setMedico(medicoRepository.findById(params.getNuovoMedico()).get());
        }
        if(params.getNuovaCartellaClinica()!=null){
            findMedicinalePrescrizione.get().setCartellaClinica(cartellaClinicaRepository.findById(params.getNuovaCartellaClinica()).get());
        }

        return MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(medicinalePrescrizioneRepository.save(findMedicinalePrescrizione.get()));
    }

    private void checkParams(PrescrizioneMedicinaleModifyParams params) {
        if(params.getIdRelazione()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire l'id della prescrizione da inserire.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleModify");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if(params.getNuovoMedicinale()==null && params.getNuovoMedico()==null && params.getNuovaCartellaClinica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro oltre all'id della relazione.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleModify");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        if(medicinalePrescrizioneRepository.findById(params.getIdRelazione()).isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna relazione trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleModify");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if((params.getNuovoMedicinale()!=null && medicinaleRepository.findById(params.getNuovoMedicinale()).isEmpty()) ||
            (params.getNuovoMedico()!=null && medicoRepository.findById(params.getNuovoMedico()).isEmpty()) ||
            (params.getNuovaCartellaClinica()!=null && cartellaClinicaRepository.findById(params.getNuovaCartellaClinica()).isEmpty())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro oltre all'id della relazione.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviMedicinaleModify");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public List<VisitaPrescrizioneDto> prescriviVisitaInfo(PrescrizioneVisitaInfoParams params) {
        checkParams(params);

        List<VisitaPrescrizione> findListVisita = findListVisitaPrescrizione(params);
        Optional<VisitaPrescrizione> findVisita = visitaPrescrizioneRepository.findById(params.getIdRelazione());
        if(!findVisita.isPresent() && findListVisita.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun elemento trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaInfo");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        } else if (findVisita.isPresent()) {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return Arrays.asList(VisitaPrescrizioneDtoMapper.INSTANCE.toDto(findVisita.get()));
        }else if (!findListVisita.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(findListVisita);
        }
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        return new ArrayList<>();
    }

    private List<VisitaPrescrizione> findListVisitaPrescrizione(PrescrizioneVisitaInfoParams params) {
        if(params.getCognomePaziente()!=null && params.getNomePaziente()!=null){
            return visitaPrescrizioneRepository.findByNomeAndCognomePaziente(params.getNomePaziente(),params.getCognomePaziente());
        }
        if(params.getCognomeMedico()!=null && params.getNomeMedico()!=null){
            return visitaPrescrizioneRepository.findByNomeAndCognomeMedico(params.getNomeMedico(),params.getCognomeMedico());
        }
        if(params.getNomeVisita()!=null){
            return visitaPrescrizioneRepository.findByNomeVisita(params.getNomeVisita());
        }
        if(params.getCognomePaziente()!=null){
            return visitaPrescrizioneRepository.findByCognomePaziente(params.getCognomePaziente());
        }
        if(params.getNomePaziente()!=null){
            return visitaPrescrizioneRepository.findByNomePaziente(params.getNomePaziente());
        }
        if(params.getCognomeMedico()!=null){
            return visitaPrescrizioneRepository.findByCognomeMedico(params.getCognomeMedico());
        }
        if(params.getNomeMedico()!=null){
            return visitaPrescrizioneRepository.findByNomeMedico(params.getNomeMedico());
        }
        if(params.getIdMedico()!=null){
            return visitaPrescrizioneRepository.findbyIdMedico(params.getIdMedico());
        }
        if(params.getIdCartella()!=null){
            return visitaPrescrizioneRepository.findbyIdCartella(params.getIdCartella());
        }
        if(params.getIdVisita()!=null){
            return visitaPrescrizioneRepository.findbyIdVisita(params.getIdVisita());
        }
        if(params.getIdPaziente()!=null){
            return visitaPrescrizioneRepository.findbyIdPaziente(params.getIdPaziente());
        }
        return new ArrayList<>();
    }

    private void checkParams(PrescrizioneVisitaInfoParams params) {
        boolean checkId = params.getIdCartella()==null && params.getIdMedico()==null && params.getIdVisita()==null &&
                params.getIdPaziente()==null && params.getIdRelazione()==null;
        boolean checkString = params.getNomeMedico()==null && params.getCognomeMedico()!=null && params.getNomePaziente()==null
                && params.getCognomePaziente()==null && params.getNomeVisita()==null;
        if(checkId && checkString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneInfo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public VisitaPrescrizioneDto prescriviVisitaAdd(PrescrizioneVisitaAddParams params) {
        checkParams(params);
        Optional<VisitaMedica> visitaMedica = visitaMedicaRepository.findById(params.getVisitaMedica());
        Optional<CartellaClinica> cartellaClinica = cartellaClinicaRepository.findById(params.getCartellaClinica());
        Optional<Medico> medico = medicoRepository.findById(params.getMedico());

        if(!visitaMedica.isPresent() || !cartellaClinica.isPresent() || !medico.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Non è stato possibile trovare uno dei tre parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneInfo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        VisitaPrescrizione visitaPrescrizione = new VisitaPrescrizione();
        visitaPrescrizione.setVisitaMedica(visitaMedica.get());
        visitaPrescrizione.setMedico(medico.get());
        visitaPrescrizione.setCartellaClinica(cartellaClinica.get());

        return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(visitaPrescrizioneRepository.save(visitaPrescrizione));
    }

    private void checkParams(PrescrizioneVisitaAddParams params) {
        if(params.getMedico()==null && params.getCartellaClinica()==null && params.getVisitaMedica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire i parametri di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaAdd");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public String prescriviVisitaDelete(Integer params) {
        if(!visitaPrescrizioneRepository.findById(params).isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna prescrizione trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaDelete");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else{
            visitaPrescrizioneRepository.deleteById(params);
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Prescrizione eliminata";
        }
    }

    public VisitaPrescrizioneDto prescriviVisitaModify(PrescrizioneVisitaModifyParams params) {
        checkParams(params);
        Optional<VisitaPrescrizione> visitaPrescrizione = visitaPrescrizioneRepository.findById(params.getIdRelazione());
        Optional<VisitaMedica> visitaMedica= null;
        Optional<Medico> medico= null;
        Optional<CartellaClinica> cartellaClinica = null;

        if(!visitaPrescrizione.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna prescrizione trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaModify");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(params.getNuovaVisitaMedica()!=null){
            visitaMedica = visitaMedicaRepository.findById(params.getNuovaVisitaMedica());
        }
        if(params.getNuovoMedico()!=null){
            medico = medicoRepository.findById(params.getNuovoMedico());
        }
        if(params.getNuovaCartellaClinica()!=null){
            cartellaClinica = cartellaClinicaRepository.findById(params.getNuovaCartellaClinica());
        }

        if(visitaMedica==null && medico==null && cartellaClinica==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun nuovo elemento trovato per poter effettuare la modifica.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaModify");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        if((visitaMedica!=null && !visitaMedica.isPresent()) && (medico!=null && !medico.isPresent())
                && (cartellaClinica!=null && !cartellaClinica.isPresent())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun nuovo elemento trovato per poter effettuare la modifica.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaModify");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        if(visitaMedica!=null && visitaMedica.isPresent()){
            visitaPrescrizione.get().setVisitaMedica(visitaMedica.get());
        }
        if(medico!=null && medico.isPresent()){
            visitaPrescrizione.get().setMedico(medico.get());
        }
        if(cartellaClinica!=null && cartellaClinica.isPresent()){
            visitaPrescrizione.get().setCartellaClinica(cartellaClinica.get());
        }

        return VisitaPrescrizioneDtoMapper.INSTANCE.toDto(visitaPrescrizioneRepository.save(visitaPrescrizione.get()));

    }

    private void checkParams(PrescrizioneVisitaModifyParams params) {
        if(params.getIdRelazione()!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire l'id della relazione.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaModify");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if(params.getNuovoMedico()==null && params.getNuovaCartellaClinica()==null && params.getNuovaVisitaMedica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire il nuovo l'elemento da modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviVisitaModify");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
