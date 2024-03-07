package com.mspaziente.service;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.dto.output.CartellaClinicaOutputDto;
import com.mspaziente.dto.params.operazionispecifiche.FindCartellaClinica;
import com.mspaziente.dto.relationentities.*;
import com.mspaziente.entity.Diagnosi;
import com.mspaziente.entity.relationentities.*;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.esito.Messaggio;
import com.mspaziente.esito.constants.EsitoOperazioneEnum;
import com.mspaziente.esito.constants.SeveritaMessaggioEnum;
import com.mspaziente.exception.EsitoRuntimeException;
import com.mspaziente.mapper.diagnosi.DiagnosiDtoMapper;
import com.mspaziente.mapper.relationentities.malattiacartella.MalattiaCartellaDtoMapper;
import com.mspaziente.mapper.relationentities.medicinalecartella.MedicinaleCartellaDtoMapper;
import com.mspaziente.mapper.relationentities.medicinaleprescrizione.MedicinalePrescrizioneDtoMapper;
import com.mspaziente.mapper.relationentities.medicinalesottoministrazione.MedicinaleSottoministrazioneDtoMapper;
import com.mspaziente.mapper.relationentities.operazionecartella.OperazioneCartellaDtoMapper;
import com.mspaziente.repository.DiagnosiRepository;
import com.mspaziente.repository.relationentities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public CartellaClinicaOutputDto findCartellaClinica(FindCartellaClinica params) {
        checkParams(params);
        CartellaClinicaOutputDto cartellaClinicaDto = null;

        List<Diagnosi> diagnosiList = diagnosiRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        if(!diagnosiList.isEmpty()){
            List<DiagnosiDto> diagnosiDto = DiagnosiDtoMapper.INSTANCE.toDto(diagnosiList);
            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setDiagnosi(diagnosiDto);
            }else{
                cartellaClinicaDto.setDiagnosi(diagnosiDto);
            }
        }

        List<MalattiaCartella> malattiaCartellaList = malattiaCartellaRepository.findByIdCartellaClinica(params.getIdCartellaClinica());

        if(!malattiaCartellaList.isEmpty()){
            List<MalattiaCartellaDto> malattiaCartellaDto = MalattiaCartellaDtoMapper.INSTANCE.toDto(malattiaCartellaList);
            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMalattie(malattiaCartellaDto);
            }else{
                cartellaClinicaDto.setMalattie(malattiaCartellaDto);
            }
        }

        List<MedicinaleCartella> medicinaleCartellaList = medicinaleCartellaRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        if(!medicinaleCartellaList.isEmpty()){
            List<MedicinaleCartellaDto> medicinaleCartellaDto = MedicinaleCartellaDtoMapper.INSTANCE.toDto(medicinaleCartellaList);
            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMedicinali(medicinaleCartellaDto);
            }else{
                cartellaClinicaDto.setMedicinali(medicinaleCartellaDto);
            }
        }

        List<MedicinalePrescrizione> medicinalePrescrizioneList = medicinalePrescrizioneRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        if(!medicinalePrescrizioneList.isEmpty()){
            List<MedicinalePrescrizioneDto> medicinalePrescrizioneDto = MedicinalePrescrizioneDtoMapper.INSTANCE.toDto(medicinalePrescrizioneList);

            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMedicinaliPrescritti(medicinalePrescrizioneDto);
            }else{
                cartellaClinicaDto.setMedicinaliPrescritti(medicinalePrescrizioneDto);
            }
        }

        List<MedicinaleSottoministrazione> medicinaleSottoministrazioneList = medicinaleSottoministrazioneRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        if(!medicinaleSottoministrazioneList.isEmpty()){
            List<MedicinaleSottoministrazioneDto> medicinalePrescrizioneDto = MedicinaleSottoministrazioneDtoMapper.INSTANCE.toDto(medicinaleSottoministrazioneList);

            if(cartellaClinicaDto==null){
                cartellaClinicaDto = new CartellaClinicaOutputDto();
                cartellaClinicaDto.setMedicinaliSottoministrti(medicinalePrescrizioneDto);
            }else{
                cartellaClinicaDto.setMedicinaliSottoministrti(medicinalePrescrizioneDto);
            }
        }

        List<OperazioneCartella> operazioneCartellaList = operazioneCartellaRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
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

    private void checkParams(FindCartellaClinica params) {
        if(params.getIdCartellaClinica() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire entrambi i parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findCartellaClinica");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

    }
}
