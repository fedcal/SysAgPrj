package com.msinfo.service;

import com.msinfo.dto.RepartoDto;
import com.msinfo.dto.params.reparto.ModificaRepartoParams;
import com.msinfo.dto.params.reparto.RicercaRepartoParams;
import com.msinfo.entity.reparto.Reparto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.medici.MedicoEntityMapper;
import com.msinfo.mapper.reparto.RepartoDtoMapper;
import com.msinfo.repository.RepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepartoService {
    @Autowired
    private RepartoRepository repartoRepository;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<RepartoDto> findAll(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                .codMsg("Find all reparto by id.").build());
        esitoMessaggiRequestContextHolder.setOperationId("findAll");
        return RepartoDtoMapper.INSTANCE.toDto(repartoRepository.findAll());
    }

    public RepartoDto findReparto(RicercaRepartoParams params) {
        if (params.getNomeReparto() == null && params.getIdReparto() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire il nome o l'id del reparto che si vuole cercare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findReparto");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if(params.getIdReparto()!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Find reparto by id.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findReparto");

            Optional<Reparto> reparto = repartoRepository.findById(params.getIdReparto());
            if (reparto.isPresent()){
                return RepartoDtoMapper.INSTANCE.toDto(reparto.get());
            }else {
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Non esiste nessun reparto con l'id indicato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("findReparto");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }

        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Find reparto by nome.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findReparto");
            return RepartoDtoMapper.INSTANCE.toDto(repartoRepository.findByNomeReparto(params.getNomeReparto()).get());
        }
    }

    public String deleteReparto(RicercaRepartoParams params) {
        if (params.getNomeReparto() == null && params.getIdReparto() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire il nome o l'id del reparto che si vuole eliminare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteReparto");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Reparto> reparto = null;
        if(params.getIdReparto() != null){
            reparto = repartoRepository.findById(params.getIdReparto());
        }else {
            reparto = repartoRepository.findByNomeReparto(params.getNomeReparto());
        }

        if(reparto.isPresent()){
            try {
                repartoRepository.delete(reparto.get());
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Reparto eliminato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteReparto");
                return "Reparto eliminato";
            }catch (EsitoRuntimeException e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Reparto non eliminato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteReparto");
                return "Reparto non eliminato";
            }
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Reparto non eliminato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteReparto");
            return "Reparto non eliminato";
        }
    }

    public RepartoDto modificaReparto(ModificaRepartoParams params) {
        if (params.getIdRepartoRicerca()==null && params.getNomeRepartoRicerca()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire il nome o l'id del reparto che si vuole modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modificaReparto");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Reparto repartoFind = null;

        if(params.getNomeRepartoRicerca()!=null){
            repartoFind=repartoRepository.findByNomeReparto(params.getNomeRepartoRicerca()).get();
        }else {
            repartoFind = repartoRepository.findById(params.getIdRepartoRicerca()).get();
        }

        if(params.getAlaRepartoNuovo()!=null){
            repartoFind.setAlaReparto(params.getAlaRepartoNuovo());
        }
        if(params.getNomeRepartoNuovo()!=null){
            repartoFind.setNomeReparto(params.getNomeRepartoNuovo());
        }
        if(params.getCapoRepartoNuovo()!=null){
            repartoFind.setCapoReparto(MedicoEntityMapper.INSTANCE.toEntity(params.getCapoRepartoNuovo()));
        }
        if(params.getDescrizioneNuovo()!=null){
            repartoFind.setDescrizione(params.getDescrizioneNuovo());
        }

        repartoRepository.save(repartoFind);

        esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                .codMsg("Reparto modificato correttamente.").build());
        esitoMessaggiRequestContextHolder.setOperationId("modificaReparto");
        return new RepartoDto();
    }
}
