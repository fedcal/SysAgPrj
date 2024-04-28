package com.msmedico.service;



import com.msmedico.dto.output.CartellaClinicaOutputDto;
import com.msmedico.dto.params.paziente.FindCartellaClinicaPazienteParams;
import com.msmedico.dto.params.paziente.FindPazienteParams;
import com.msmedico.dto.paziente.DiagnosiDto;
import com.msmedico.dto.paziente.PazienteDto;
import com.msmedico.dto.relationentities.MalattiaCartellaDto;
import com.msmedico.dto.relationentities.MedicinaleCartellaDto;
import com.msmedico.dto.relationentities.MedicinalePrescrizioneDto;
import com.msmedico.dto.relationentities.OperazioneCartellaDto;
import com.msmedico.entity.paziente.Diagnosi;
import com.msmedico.entity.paziente.Paziente;
import com.msmedico.entity.relationentities.*;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.Messaggio;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.exception.EsitoRuntimeException;
import com.msmedico.mapper.paziente.diagnosi.DiagnosiDtoMapper;
import com.msmedico.mapper.paziente.paziente.PazienteDtoMapper;
import com.msmedico.mapper.relationentities.malattiacartella.MalattiaCartellaDtoMapper;
import com.msmedico.mapper.relationentities.medicinalecartella.MedicinaleCartellaDtoMapper;
import com.msmedico.mapper.relationentities.medicinaleprescrizione.MedicinalePrescrizioneDtoMapper;
import com.msmedico.mapper.relationentities.medicinalesottoministrazione.MedicinaleSottoministrazioneDtoMapper;
import com.msmedico.mapper.relationentities.operazionecartella.OperazioneCartellaDtoMapper;
import com.msmedico.mspaziente.model.MedicinaleSottoministrazioneDto;
import com.msmedico.repository.paziente.DiagnosiRepository;
import com.msmedico.repository.paziente.PazienteRepository;
import com.msmedico.repository.relationentities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PazienteService {
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
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    public List<PazienteDto> getAllPazienti() {
        List<Paziente> pazienti = pazienteRepository.findAll();

        if(pazienti.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista paziente vuota.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            List<PazienteDto> pazienteDto = PazienteDtoMapper.INSTANCE.toDto(pazienti);
            return pazienteDto;
        }
    }

    public List<PazienteDto> findInfoPazienti(FindPazienteParams params) {
        checkParams(params);
        List<Paziente> findPaziente = new ArrayList<>();

        if(params.getIdPaziente()!=null){
            Optional<Paziente> findById = pazienteRepository.findById(params.getIdPaziente());
            if(findById.isPresent()){
                findPaziente.add(findById.get());
            }
        }

        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome()) && StringUtils.hasLength(params.getDataNascita())){
            findPaziente.addAll(pazienteRepository.findByNomeAndCognomeAndData(params.getNome(),params.getCognome(),params.getDataNascita()));
        }

        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome())){
            findPaziente.addAll(pazienteRepository.findByNomeAndCognome(params.getNome(),params.getCognome()));
        }

        if(StringUtils.hasLength(params.getNome())){
            findPaziente.addAll(pazienteRepository.findByNome(params.getNome()));
        }

        if(StringUtils.hasLength(params.getCognome())){
            findPaziente.addAll(pazienteRepository.findByCognome(params.getCognome()));
        }

        if(StringUtils.hasLength(params.getDataNascita())){
            findPaziente.addAll(pazienteRepository.findByDataNascita(params.getDataNascita()));
        }
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("findInfoPazienti");
        return PazienteDtoMapper.INSTANCE.toDto(findPaziente);
    }
    private void checkParams(FindPazienteParams params) {
        if(params.getIdPaziente()==null && !StringUtils.hasLength(params.getNome()) && !StringUtils.hasLength(params.getCognome()) && !StringUtils.hasLength(params.getDataNascita())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public CartellaClinicaOutputDto findCartellaClinica(FindCartellaClinicaPazienteParams params) {
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
    private void checkParams(FindCartellaClinicaPazienteParams params) {
        if(params.getIdCartellaClinica() == null && params.getIdPaziente()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findCartellaClinica");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

    }
}
