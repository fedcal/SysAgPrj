package com.msmedico.service;

import com.msmedico.constants.ReturnMessagge;
import com.msmedico.dto.params.visualizzastato.FindCartellaClinicaParams;
import com.msmedico.dto.params.visualizzastato.FindOperazioneParams;
import com.msmedico.dto.params.visualizzastato.FindStatoVisitaMedicaParams;
import com.msmedico.dto.paziente.CartellaClinicaDto;
import com.msmedico.dto.relationentities.OperazioneCartellaDto;
import com.msmedico.dto.relationentities.VisitaMedicaCartellaDto;
import com.msmedico.entity.paziente.CartellaClinica;
import com.msmedico.entity.relationentities.OperazioneCartella;
import com.msmedico.entity.relationentities.VisitaMedicaCartella;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.Messaggio;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.exception.EsitoRuntimeException;
import com.msmedico.mapper.paziente.cartellaclinica.CartellaClinicaDtoMapper;
import com.msmedico.mapper.relationentities.visitamedicacartella.VisitaMedicaCartellaDtoMapper;
import com.msmedico.repository.paziente.CartellaClinicaRepository;
import com.msmedico.repository.relationentities.OperazioneCartellaRepository;
import com.msmedico.repository.relationentities.VisitaMedicaCartellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VisualizzaStatoService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private VisitaMedicaCartellaRepository visitaMedicaCartellaRepository;

    @Autowired
    private CartellaClinicaRepository cartellaClinicaRepository;

    @Autowired
    private OperazioneCartellaRepository operazioneCartellaRepository;

    public List<VisitaMedicaCartellaDto> statoVisita(FindStatoVisitaMedicaParams params) {
        checkParams(params);
        Optional<VisitaMedicaCartella> visitaMedicaCartellaFindId = Optional.empty();

        List<VisitaMedicaCartella> visitaMedicaCartellaFindList = new ArrayList<>();
        List<VisitaMedicaCartellaDto> visitaMedicaCartellaReturn = new ArrayList<>();

        if(params.getIdCartella()!=null && params.getIdVisitaMedica()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdCartellaAndIdVisitaMedica(params.getIdCartella(),
                    params.getIdVisitaMedica());
        }

        if(params.getIdRelazione()!=null){
            visitaMedicaCartellaFindId = visitaMedicaCartellaRepository.findById(params.getIdRelazione());
        }

        if(params.getIdVisitaMedica()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdVisitaMedica(params.getIdVisitaMedica());
        }

        if(params.getIdCartella()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdCartella(params.getIdCartella());
        }

        if(params.getIdReferto()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdReferto(params.getIdReferto());
        }

        if(visitaMedicaCartellaFindId!=null && !visitaMedicaCartellaFindId.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg(ReturnMessagge.NOT_FOUND).build());
            esitoMessaggiRequestContextHolder.setOperationId("statoVisita");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        if(visitaMedicaCartellaFindId!=null && visitaMedicaCartellaFindId.isPresent()){
            visitaMedicaCartellaReturn.add(VisitaMedicaCartellaDtoMapper.INSTANCE.toDto(visitaMedicaCartellaFindId.get()));
        }

        if (!visitaMedicaCartellaFindList.isEmpty()) {
            visitaMedicaCartellaReturn.addAll(VisitaMedicaCartellaDtoMapper.INSTANCE.toDto(visitaMedicaCartellaFindList));
        } else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg(ReturnMessagge.NOT_FOUND).build());
            esitoMessaggiRequestContextHolder.setOperationId("statoVisita");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        return visitaMedicaCartellaReturn;
    }

    private void checkParams(FindStatoVisitaMedicaParams params) {
        if(params.getIdCartella()==null && params.getIdRelazione()==null && params.getIdReferto() == null && params.getIdVisitaMedica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg(ReturnMessagge.PARAMETRI_RICERCA).build());
            esitoMessaggiRequestContextHolder.setOperationId("statoVisita");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<CartellaClinicaDto> statoCartellaClinica(FindCartellaClinicaParams params) {
        checkParams(params);

        Optional<CartellaClinica> cartellaClinicaFindId = Optional.empty();

        List<CartellaClinica> cartellaClinicaFindList = new ArrayList<>();
        List<CartellaClinicaDto> cartellaClinicaReturn = new ArrayList<>();

        if(params.getNome()!=null && params.getCognome()!=null){
            cartellaClinicaFindList = cartellaClinicaRepository.findByNomePazienteAndCognomePaziente(params.getNome(),params.getCognome());
        }
        if(params.getIdCartellaClinica()!=null){
            cartellaClinicaFindId = cartellaClinicaRepository.findById(params.getIdCartellaClinica());
        }
        if(params.getIdPaziente()!=null){
            cartellaClinicaFindId = cartellaClinicaRepository.findByPazienteId(params.getIdPaziente());
        }
        if(params.getNome()!=null && params.getCognome()==null){
            cartellaClinicaFindList = cartellaClinicaRepository.findByNomePaziente(params.getNome());
        }
        if(params.getCognome()!=null && params.getNome()==null){
            cartellaClinicaFindList = cartellaClinicaRepository.findByCognomePaziente(params.getCognome());
        }

        if(!cartellaClinicaFindId.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun elemento trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("statoCartellaClinica");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(cartellaClinicaFindId.isPresent()){
            cartellaClinicaReturn.add(CartellaClinicaDtoMapper.INSTANCE.toDto(cartellaClinicaFindId.get()));
        }

        if (!cartellaClinicaFindList.isEmpty()) {
            cartellaClinicaReturn.addAll(CartellaClinicaDtoMapper.INSTANCE.toDto(cartellaClinicaFindList));
        } else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun elemento trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("statoCartellaClinica");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        return cartellaClinicaReturn;
    }

    private void checkParams(FindCartellaClinicaParams params) {
        if(params.getIdPaziente() == null && params.getIdCartellaClinica() == null && params.getNome() == null &&
                params.getCognome()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg(ReturnMessagge.PARAMETRI_RICERCA).build());
            esitoMessaggiRequestContextHolder.setOperationId("statoCartellaClinica");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<OperazioneCartellaDto> operazioneCartella(FindOperazioneParams params) {
        checkParams(params);

        Optional<OperazioneCartella> cartellaClinicaFindId = Optional.empty();

        List<OperazioneCartella> cartellaClinicaFindList = new ArrayList<>();
        List<OperazioneCartellaDto> cartellaClinicaReturn = new ArrayList<>();

        cartellaClinicaFindId = findById(params);

        cartellaClinicaFindList = findByStringParams(params);


        return new ArrayList<>();
    }

    private List<OperazioneCartella> findByStringParams(FindOperazioneParams params) {
        if(params.getNomeOperazione()!=null){
            return operazioneCartellaRepository.findByNomeOperazione(params.getNomeOperazione());
        }
        if(params.getNomePaziente()!=null && params.getCognomePaziente()!=null){
            return operazioneCartellaRepository.findByNomePazienteAndCognomePaziente(params.getNomePaziente(),params.getCognomePaziente());
        }
        if(params.getNomePaziente()!=null && params.getCognomePaziente()==null){
            return operazioneCartellaRepository.findByNomePaziente(params.getNomePaziente());
        }
        if(params.getNomePaziente()==null && params.getCognomePaziente()!=null){
            return operazioneCartellaRepository.findByCognomePaziente(params.getCognomePaziente());
        }

        if(params.getNomeMedico()!=null && params.getCognomeMedico()!=null){
            return operazioneCartellaRepository.findByNomeMedicoAndCognomeMedico(params.getNomeMedico(),params.getCognomeMedico());
        }
        if(params.getNomeMedico()!=null && params.getCognomeMedico()==null){
            return operazioneCartellaRepository.findByNomeMedico(params.getNomeMedico());
        }
        if(params.getNomeMedico()==null && params.getCognomeMedico()!=null){
            return operazioneCartellaRepository.findByCognomeMedico(params.getCognomeMedico());
        }
        return new ArrayList<>();
    }

    private Optional<OperazioneCartella> findById(FindOperazioneParams params) {
        if(params.getIdRelazione()!=null){
            return operazioneCartellaRepository.findById(params.getIdRelazione());
        }
        if(params.getIdOperazione()!=null){
            return operazioneCartellaRepository.findByIdOperazione(params.getIdOperazione());
        }
        if(params.getIdCartellaClinica()!=null){
            return operazioneCartellaRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        }
        if(params.getIdPaziente()!=null){
            return operazioneCartellaRepository.findByIdPaziente(params.getIdPaziente());
        }
        if(params.getIdMedico()!=null){
            return operazioneCartellaRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdReferto()!=null){
            return operazioneCartellaRepository.findByIdReferto(params.getIdReferto());
        }

        return  Optional.empty();
    }

    private void checkParams(FindOperazioneParams params) {
        boolean idCheck = params.getIdOperazione()==null && params.getIdMedico()==null && params.getIdCartellaClinica()==null
                && params.getIdRelazione()==null && params.getIdPaziente()==null && params.getIdReferto()==null;
        boolean stringCheck = params.getNomeOperazione()==null && params.getNomePaziente()==null && params.getCognomePaziente()==null
                && params.getNomeMedico()==null && params.getCognomeMedico()==null;
        if(idCheck && stringCheck){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg(ReturnMessagge.PARAMETRI_RICERCA).build());
            esitoMessaggiRequestContextHolder.setOperationId("statoCartellaClinica");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
