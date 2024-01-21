package com.msmedico.service;

import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleAddParams;
import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleInfoParams;
import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleModifyParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneAddParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneInfoParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneModifyParams;
import com.msmedico.dto.relationentities.MedicinalePrescrizioneDto;
import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
import com.msmedico.entity.Medicinale;
import com.msmedico.entity.Medico;
import com.msmedico.entity.operazione.OperazioneMedica;
import com.msmedico.entity.paziente.CartellaClinica;
import com.msmedico.entity.relationentities.MedicinalePrescrizione;
import com.msmedico.entity.relationentities.OperazionePrescrizione;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.Messaggio;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.exception.EsitoRuntimeException;
import com.msmedico.mapper.relationentities.medicinaleprescrizione.MedicinalePrescrizioneDtoMapper;
import com.msmedico.mapper.relationentities.operazioneprescrizione.OperazionePrescrizioneDtoMapper;
import com.msmedico.repository.MedicinaleRepository;
import com.msmedico.repository.MedicoRepository;
import com.msmedico.repository.operazione.OperazioneMedicaRepository;
import com.msmedico.repository.paziente.CartellaClinicaRepository;
import com.msmedico.repository.relationentities.MedicinalePrescrizioneRepository;
import com.msmedico.repository.relationentities.OperazionePrescrizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<OperazionePrescrizioneDto> prescriviOperazioneInfo(PrescrizioneOperazioneInfoParams params) {
        checkParams(params);

        Optional<OperazionePrescrizione> operazionePrescrizioneById = findOperazioneById(params);
        List<OperazionePrescrizione> operazionePrescrizioneByString = findOperazioneByString(params);

        if(operazionePrescrizioneById.isEmpty()&&operazionePrescrizioneByString.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna operazione trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("prescriviOperazioneInfo");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        if(operazionePrescrizioneById.isPresent()){
            List<OperazionePrescrizioneDto> listaReturn = new ArrayList<>();
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            listaReturn.add(OperazionePrescrizioneDtoMapper.INSTANCE.toDto(operazionePrescrizioneById.get()));
            return listaReturn;
        }

        if(!operazionePrescrizioneByString.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return OperazionePrescrizioneDtoMapper.INSTANCE.toDto(operazionePrescrizioneByString);
        }
        return new ArrayList<>();
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
        return new ArrayList<>();
    }

    private Optional<OperazionePrescrizione> findOperazioneById(PrescrizioneOperazioneInfoParams params) {
        if (params.getIdOperazione()!=null){
            return operazionePrescrizioneRepository.findByIdOperazione(params.getIdOperazione());
        }
        if(params.getIdCartella()!=null){
            return operazionePrescrizioneRepository.findByIdCartella(params.getIdCartella());
        }
        if(params.getIdMedico()!=null){
            return operazionePrescrizioneRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdPaziente()!=null){
            return operazionePrescrizioneRepository.findByIdPaziente(params.getIdPaziente());
        }
        return Optional.empty();
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
        Optional<OperazionePrescrizione> findOperazionePrescrizione = operazionePrescrizioneRepository.findByIdOperazione(params.getIdRelazione());
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
        Optional<OperazionePrescrizione> findOperazionePrescrizione = Optional.empty();
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


        if( (params.getIdRelazione()!=null && !findOperazionePrescrizione.isPresent())
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
}
