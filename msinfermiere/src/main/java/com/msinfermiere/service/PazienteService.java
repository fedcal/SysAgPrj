package com.msinfermiere.service;

import com.msinfermiere.dto.output.CartellaClinicaOutputDto;
import com.msinfermiere.dto.params.FindCartellaClinicaParams;
import com.msinfermiere.dto.params.PazienteFiltratiParams;
import com.msinfermiere.dto.paziente.DiagnosiDto;
import com.msinfermiere.dto.paziente.PazienteDto;
import com.msinfermiere.dto.relationentities.*;
import com.msinfermiere.entity.paziente.Diagnosi;
import com.msinfermiere.entity.paziente.Paziente;
import com.msinfermiere.entity.relationentites.*;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.Messaggio;
import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import com.msinfermiere.esito.constants.SeveritaMessaggioEnum;
import com.msinfermiere.exception.EsitoRuntimeException;
import com.msinfermiere.mapper.paziente.diagnosi.DiagnosiDtoMapper;
import com.msinfermiere.mapper.paziente.paziente.PazienteDtoMapper;
import com.msinfermiere.mapper.relationentities.malattiacartella.MalattiaCartellaDtoMapper;
import com.msinfermiere.mapper.relationentities.medicinalecartella.MedicinaleCartellaDtoMapper;
import com.msinfermiere.mapper.relationentities.medicinaleprescrizione.MedicinalePrescrizioneDtoMapper;
import com.msinfermiere.mapper.relationentities.medicinalesottoministrazione.MedicinaleSottoministrazioneDtoMapper;
import com.msinfermiere.mapper.relationentities.operazionecartella.OperazioneCartellaDtoMapper;
import com.msinfermiere.repository.paziente.DiagnosiRepository;
import com.msinfermiere.repository.paziente.PazienteRepository;
import com.msinfermiere.repository.relationentites.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PazienteService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private PazienteRepository pazienteRepository;

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
    @Transactional
    public List<PazienteDto> getAllPazienti() {
        List<Paziente> findAll = pazienteRepository.findAll();
        if(findAll.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista paziente vuota.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            return PazienteDtoMapper.INSTANCE.toDto(findAll);
        }
    }

    public List<PazienteDto> getPazientiFiltrati(PazienteFiltratiParams params) {
        checkParams(params);
        List<Paziente> findListPaziente = new ArrayList<>();

        if(params.getIdPaziente()!=null){
            findListPaziente = Arrays.asList(pazienteRepository.findById(params.getIdPaziente()).get());
        }
        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome())){
            findListPaziente = pazienteRepository.findByNomeAndCognomePaziente(params.getNome(),params.getCognome());
        }
        if(StringUtils.hasLength(params.getNome())){
            findListPaziente = pazienteRepository.findByNomePaziente(params.getNome());
        }
        if(StringUtils.hasLength(params.getCognome())){
            findListPaziente = pazienteRepository.findByCognomePaziente(params.getCognome());
        }
        if(findListPaziente.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun paziente trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPazientiFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{

            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getPazientiFiltrati");
            return PazienteDtoMapper.INSTANCE.toDto(findListPaziente);
        }
    }

    private void checkParams(PazienteFiltratiParams params) {
        if(params.getIdPaziente()!=null && !StringUtils.hasLength(params.getNome()) && !StringUtils.hasLength(params.getCognome())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPazientiFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

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
}
