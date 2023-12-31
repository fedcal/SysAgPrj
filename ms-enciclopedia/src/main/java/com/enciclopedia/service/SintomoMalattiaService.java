package com.enciclopedia.service;

import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaChangeParams;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaParams;
import com.enciclopedia.entity.relationship.SintomoMalattia;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.Messaggio;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.esito.costants.SeveritaMessaggioEnum;
import com.enciclopedia.exception.EsitoRuntimeException;
import com.enciclopedia.mapper.sintomomalattia.SintomoMalattiaDtoMapper;
import com.enciclopedia.mapper.sintomomalattia.SintomoMalattiaEntityMapper;
import com.enciclopedia.repository.SintomoMalattiaRepository;
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
    private SintomoMalattiaConverterSevice serviceConvert;
    @Autowired
    private SintomoMalattiaRepository repository;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<SintomoMalattiaDto> getAll() {
        return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.findAll());
    }

    public SintomoMalattiaDto addSintomo(SintomoMalattiaParams params) {
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
                esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Relazione tra sintomo " +
                        "e malattia già presente.", SeveritaMessaggioEnum.ERROR));
                esitoMessaggiRequestContextHolder.setOperationId("addSintomoaddSintomo");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }else{
                List<SintomoMalattia> listaTotale = repository.findAll();
                return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.save(toSave));
            }
        }
    }

    private Messaggio creazioneMessaggio(String messaggio, SeveritaMessaggioEnum severitaMessaggioEnum) {
        Messaggio m = Messaggio.builder()
                        .severita(severitaMessaggioEnum)
                        .codMsg(messaggio).build();
        return m;
    }

    public SintomoMalattiaDto infoSintomo(SintomoMalattiaParams params) {
        if(params.getIdSintomo() == null && params.getIdMalattia() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Inserire parametri di " +
                    "ricerca", SeveritaMessaggioEnum.ERROR));
            esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        List<SintomoMalattiaDto> listaRelazioni = SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.findAll());
        if(listaRelazioni.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Non ho trovato nessuna " +
                    "relazione tra sintomi e malattie", SeveritaMessaggioEnum.ERROR));
            esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        AtomicReference<SintomoMalattiaDto> returnRelazione = new AtomicReference<>();
        listaRelazioni.stream().forEach(e ->{
            boolean checkIdMalattia = e.getIdMalattia() == params.getIdMalattia();
            boolean checkIdSintomo = String.valueOf(params.getIdSintomo()).equals(String.valueOf(e.getIdSintomo()));
            if(checkIdSintomo && checkIdMalattia){
                returnRelazione.set(e);
            }
        });
        return returnRelazione.get();
    }

    public String deleteSintomoRelation(SintomoMalattiaParams params) {
        if(params.getIdSintomo() == null && params.getIdMalattia() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Inserire parametri di " +
                    "ricerca", SeveritaMessaggioEnum.ERROR));
            esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        List<SintomoMalattiaDto> listaRelazioni = SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.findAll());
        if(listaRelazioni.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Non ho trovato nessuna " +
                    "relazione tra sintomi e malattie", SeveritaMessaggioEnum.ERROR));
            esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        AtomicReference<SintomoMalattiaDto> returnRelazione = new AtomicReference<>();
        listaRelazioni.stream().forEach(e ->{
            boolean checkIdMalattia = e.getIdMalattia() == params.getIdMalattia();
            boolean checkIdSintomo = String.valueOf(params.getIdSintomo()).equals(String.valueOf(e.getIdSintomo()));
            if(checkIdSintomo && checkIdMalattia){
                returnRelazione.set(e);
            }
        });
        try{
            repository.deleteById(returnRelazione.get().getIdRelazione());
        }catch (IllegalArgumentException e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Ho trovato la relazione, " +
                    "ma non sono riuscito ad eliminarla", SeveritaMessaggioEnum.ERROR));
            esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        return "Sono riuscito ad eliminare la relazione tra la malattia e il sintomo.";
    }

    public SintomoMalattiaDto modifySintomo(SintomoMalattiaChangeParams params) {
        Optional<SintomoMalattiaDto> sintomoMalattiaDto;
        if(params.getIdRelazione()!=null){
            sintomoMalattiaDto = Optional.ofNullable(SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.findById(params.getIdRelazione()).get()));
        }else {
            List<SintomoMalattiaDto> listaRelazioni = SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.findAll());
            if(listaRelazioni.isEmpty()){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Non ho trovato nessuna " +
                        "relazione tra sintomi e malattie", SeveritaMessaggioEnum.ERROR));
                esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
            AtomicReference<SintomoMalattiaDto> returnRelazione = new AtomicReference<>();
            listaRelazioni.stream().forEach(e ->{
                boolean checkIdMalattia = e.getIdMalattia() == params.getIdMalattia();
                boolean checkIdSintomo = String.valueOf(params.getIdSintomo()).equals(String.valueOf(e.getIdSintomo()));
                if(checkIdSintomo && checkIdMalattia){
                    returnRelazione.set(e);
                }
            });
            sintomoMalattiaDto = Optional.of(returnRelazione.get());
        }
        if(!sintomoMalattiaDto.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(creazioneMessaggio("Non ho trovato nessuna " +
                    "relazione tra sintomi e malattie", SeveritaMessaggioEnum.ERROR));
            esitoMessaggiRequestContextHolder.setOperationId("SintomoMalattiaParams");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        if(params.getNewIdSitnomo()!=null){
            sintomoMalattiaDto.get().setIdSintomo(params.getNewIdSitnomo());
        }else if(params.getIdMalattia()!=null){
            sintomoMalattiaDto.get().setIdMalattia(params.getNewIdMalattia());
        }

        return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.save(SintomoMalattiaEntityMapper.INSTANCE.toEntity(sintomoMalattiaDto.get())));
    }
}
