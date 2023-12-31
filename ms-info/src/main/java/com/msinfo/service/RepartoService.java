package com.msinfo.service;

import com.msinfo.dto.MedicoDto;
import com.msinfo.dto.RepartoDto;
import com.msinfo.dto.params.reparto.AddRepartoParams;
import com.msinfo.dto.params.reparto.ModificaRepartoParams;
import com.msinfo.dto.params.reparto.RicercaRepartoParams;
import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.reparto.Reparto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.medici.MedicoDtoMapper;
import com.msinfo.mapper.medici.MedicoEntityMapper;
import com.msinfo.mapper.reparto.RepartoDtoMapper;
import com.msinfo.repository.MedicoRepository;
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

    @Autowired
    private MedicoRepository medicoRepository;

    public List<RepartoDto> findAll(){
        List<Reparto> listaReparti = repartoRepository.findAll();
        if(listaReparti.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna lista").build());
            esitoMessaggiRequestContextHolder.setOperationId("findAll");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
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

            Optional<Reparto> reparto =repartoRepository.findByNomeReparto(params.getNomeReparto());
            if (reparto.isPresent()){
                return RepartoDtoMapper.INSTANCE.toDto(reparto.get());
            }else {
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Non esiste nessun reparto con l'id indicato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("findReparto");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
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

        Optional<Reparto> reparto;
        if(params.getIdReparto() != null){
            reparto = repartoRepository.findById(params.getIdReparto());
        }else {
            reparto = repartoRepository.findByNomeReparto(params.getNomeReparto());
        }

        if(reparto.isPresent()){
            try {
                repartoRepository.delete(reparto.get());
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
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
            Optional<Medico> capoRepartoFind = medicoRepository.findById(params.getCapoRepartoNuovo());
            if(capoRepartoFind.isPresent()){
                repartoFind.setCapoReparto(capoRepartoFind.get());
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Capo reparto non trovato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("modificaReparto");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }
        if(params.getDescrizioneNuovo()!=null){
            repartoFind.setDescrizione(params.getDescrizioneNuovo());
        }

        repartoRepository.save(repartoFind);
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        return RepartoDtoMapper.INSTANCE.toDto(repartoFind);
    }

    public RepartoDto aggiuntaReparto(AddRepartoParams params) {
        MedicoDto caporeparto  = checkCapoRepartoExist(params.getCapoReparto());

        Reparto repartoToSave = new Reparto();

        repartoToSave.setCapoReparto(MedicoEntityMapper.INSTANCE.toEntity(caporeparto));
        repartoToSave.setNomeReparto(params.getNomeReparto());
        repartoToSave.setDescrizione(params.getDescrizione());
        repartoToSave.setAlaReparto(params.getAlaReparto());

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        repartoRepository.save(repartoToSave);

        return RepartoDtoMapper.INSTANCE.toDto(repartoToSave);
    }

    private MedicoDto checkCapoRepartoExist(Integer capoReparto) {
        Optional<Medico> findMedico = medicoRepository.findById(capoReparto);
        if(findMedico.isPresent()){
            return MedicoDtoMapper.INSTANCE.toDto(findMedico.get());
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Capo reparto non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiuntaReparto");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
