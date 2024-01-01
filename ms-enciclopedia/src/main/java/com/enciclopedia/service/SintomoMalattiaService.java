package com.enciclopedia.service;

import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.dto.output.SintomoMalattiaOutput;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaChangeParams;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaParams;
import com.enciclopedia.entity.relationship.SintomoMalattia;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.Messaggio;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.esito.costants.SeveritaMessaggioEnum;
import com.enciclopedia.exception.EsitoRuntimeException;
import com.enciclopedia.mapper.malattia.MalattiaDtoMapper;
import com.enciclopedia.mapper.sintomo.SintomoDtoMapper;
import com.enciclopedia.mapper.sintomomalattia.SintomoMalattiaDtoMapper;
import com.enciclopedia.mapper.sintomomalattia.SintomoMalattiaEntityMapper;
import com.enciclopedia.repository.MalattiaRepository;
import com.enciclopedia.repository.SintomoMalattiaRepository;
import com.enciclopedia.repository.SintomoRepository;
import com.enciclopedia.service.converter.SintomoMalattiaConverterSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SintomoMalattiaService {

    @Autowired
    private SintomoMalattiaRepository repository;

    @Autowired
    private SintomoRepository sintomoRepository;

    @Autowired
    private MalattiaRepository malattiaRepository;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<SintomoMalattiaDto> getAll() {
        return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.findAll());
    }

    public SintomoMalattiaDto addRelazione(SintomoMalattiaParams params) {
        List<SintomoMalattia> listaSintomo = repository.findBySintomo(params.getIdSintomo());
        SintomoMalattia toSave = new SintomoMalattia();
        toSave.setIdMalattia(params.getIdMalattia());
        toSave.setIdSintomo(params.getIdSintomo());
        if(listaSintomo.isEmpty()) {
            return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.save(toSave));
        }else{
            AtomicBoolean isPresent = new AtomicBoolean(false);
            listaSintomo.stream().forEach(e->{
                if(e.getIdMalattia() == params.getIdMalattia() && e.getIdSintomo() == params.getIdSintomo())
                    isPresent.set(true);
            });
            if (isPresent.get()){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.setOperationId("addSintomoaddSintomo");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.save(toSave));
            }
        }
    }

    public SintomoMalattiaOutput infoRelazione(SintomoMalattiaParams params) {
        if(params.getIdRelazione()==null || params.getIdSintomo() == null && params.getIdMalattia() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci l'id della relazione da cancellare o l'id del sintomo + l'id della malattia").build());
            esitoMessaggiRequestContextHolder.setOperationId("infoRelazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        Optional<SintomoMalattia> sintomoMalattiaFind;
        if(params.getIdRelazione()!=null){
            sintomoMalattiaFind = repository.findById(params.getIdRelazione());
        }else{
            sintomoMalattiaFind = repository.findBySintomoAndMalattia(params.getIdSintomo(),params.getIdMalattia());
        }
        if(sintomoMalattiaFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("infoRelazione");

            SintomoMalattiaOutput sintomoMalattiaOutput = new SintomoMalattiaOutput();
            sintomoMalattiaOutput.setIdRelazione(sintomoMalattiaFind.get().getIdRelazione());
            sintomoMalattiaOutput.setSintomoDto(SintomoDtoMapper.INSTANCE.toDto(
                    sintomoRepository.findById(params.getIdSintomo()).get()));
            sintomoMalattiaOutput.setMalattiaDto(MalattiaDtoMapper.INSTANCE.toDto(
                    malattiaRepository.findById(params.getIdMalattia()).get()
            ));

            return sintomoMalattiaOutput;
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("infoRelazione");
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Non è stato possibile eliminare la relazione").build());
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteSintomoRelation(SintomoMalattiaParams params) {
        if(params.getIdRelazione()==null || params.getIdSintomo() == null && params.getIdMalattia() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci l'id della relazione da cancellare o l'id del sintomo + l'id della malattia").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteSintomoRelation");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        Optional<SintomoMalattia> sintomoMalattiaFind;
        if(params.getIdRelazione()!=null){
            sintomoMalattiaFind = repository.findById(params.getIdRelazione());
        }else{
            sintomoMalattiaFind = repository.findBySintomoAndMalattia(params.getIdSintomo(),params.getIdMalattia());
        }

        if(sintomoMalattiaFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("deleteSintomoRelation");
            repository.deleteById(sintomoMalattiaFind.get().getIdRelazione());
            return "Sono riuscito ad eliminare la relazione tra la malattia e il sintomo.";
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Non è stato possibile eliminare la relazione").build());
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public SintomoMalattiaDto modifyRelazione(SintomoMalattiaChangeParams params) {
        Optional<SintomoMalattia> sintomoMalattiaFind;
        if(params.getIdRelazione()==null || params.getIdSintomo() == null && params.getIdMalattia() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci l'id della relazione da cancellare o l'id del sintomo + l'id della malattia").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyRelazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        if(params.getIdRelazione()!=null) {
            sintomoMalattiaFind = repository.findById(params.getIdRelazione());
        }else{
            sintomoMalattiaFind = repository.findBySintomoAndMalattia(params.getIdSintomo(), params.getIdMalattia());
        }

        if(sintomoMalattiaFind.isPresent()){
            if(params.getNewIdMalattia()!=null){
                sintomoMalattiaFind.get().setIdMalattia(params.getNewIdMalattia());
            }
            if(params.getNewIdSitnomo()!=null){
                sintomoMalattiaFind.get().setIdSintomo(params.getNewIdSitnomo());
            }
            return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.save(sintomoMalattiaFind.get()));
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna relazione trovata").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyRelazione");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

    }
}
