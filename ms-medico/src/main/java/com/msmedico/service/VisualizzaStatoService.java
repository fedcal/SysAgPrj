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
import com.msmedico.mapper.relationentities.operazionecartella.OperazioneCartellaDtoMapper;
import com.msmedico.mapper.relationentities.visitamedicacartella.VisitaMedicaCartellaDtoMapper;
import com.msmedico.repository.paziente.CartellaClinicaRepository;
import com.msmedico.repository.relationentities.OperazioneCartellaRepository;
import com.msmedico.repository.relationentities.VisitaMedicaCartellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
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

        if(visitaMedicaCartellaFindId.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg(ReturnMessagge.NOT_FOUND).build());
            esitoMessaggiRequestContextHolder.setOperationId("statoVisita");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        if(visitaMedicaCartellaFindId.isPresent()){
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

        List<OperazioneCartella> cartellaClinicaFindId = findById(params);
        List<OperazioneCartella> cartellaClinicaFindList = findByStringParams(params);

        if(cartellaClinicaFindId.isEmpty() && cartellaClinicaFindList.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun elemento trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("operazioneCartella");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else {
            if (!cartellaClinicaFindId.isEmpty()){
                return OperazioneCartellaDtoMapper.INSTANCE.toDto(cartellaClinicaFindId);
            } else if (!cartellaClinicaFindList.isEmpty()) {
                return OperazioneCartellaDtoMapper.INSTANCE.toDto(cartellaClinicaFindList);
            }
        }
        return new ArrayList<>();
    }

    private List<OperazioneCartella> findByStringParams(FindOperazioneParams params) {
        if(params.getNomeOperazione()!=null){
            return operazioneCartellaRepository.findByNomeOperazione(params.getNomeOperazione());
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

    private List<OperazioneCartella> findById(FindOperazioneParams params) {
        if(params.getIdRelazione()!=null){
            return Arrays.asList(operazioneCartellaRepository.findById(params.getIdRelazione()).get());
        }
        if(params.getIdOperazione()!=null){
            return operazioneCartellaRepository.findByIdOperazione(params.getIdOperazione());
        }
        if(params.getIdCartellaClinica()!=null){
            return operazioneCartellaRepository.findByIdCartellaClinica(params.getIdCartellaClinica());
        }
        if(params.getIdMedico()!=null){
            return operazioneCartellaRepository.findByIdMedico(params.getIdMedico());
        }
        if(params.getIdReferto()!=null){
            return operazioneCartellaRepository.findByIdReferto(params.getIdReferto());
        }

        return  new ArrayList<>();
    }

    private void checkParams(FindOperazioneParams params) {
        boolean idCheck = params.getIdOperazione()==null && params.getIdMedico()==null && params.getIdCartellaClinica()==null
                && params.getIdRelazione()==null && params.getIdPaziente()==null && params.getIdReferto()==null;
        boolean stringCheck = StringUtils.hasLength(params.getNomeOperazione()) && StringUtils.hasLength(params.getNomePaziente())
                && StringUtils.hasLength(params.getCognomePaziente())
                && StringUtils.hasLength(params.getNomeMedico()) && StringUtils.hasLength(params.getCognomeMedico());
        if(idCheck && stringCheck){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg(ReturnMessagge.PARAMETRI_RICERCA).build());
            esitoMessaggiRequestContextHolder.setOperationId("statoCartellaClinica");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
