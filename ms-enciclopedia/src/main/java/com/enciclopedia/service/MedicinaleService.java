package com.enciclopedia.service;

import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.dto.params.medicinale.MedicinaleInfoParams;
import com.enciclopedia.dto.params.medicinale.MedicinaleParams;
import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.exception.EsitoRuntimeException;
import com.enciclopedia.mapper.medicinale.MedicinaleDtoMapper;
import com.enciclopedia.repository.MedicinaleRepository;
import com.enciclopedia.service.converter.MedicinaleServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicinaleService {

    @Autowired
    private MedicinaleServiceConverter serviceConverter;
    @Autowired
    private MedicinaleRepository repository;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<MedicinaleDto> findAllMedicinali(){
        return  serviceConverter.findAll();
    }
    public MedicinaleDto findInfoMedicinale(MedicinaleInfoParams params) {
        Optional<Medicinale> medicinaleDto;
        checkParamsMedicinale(params);
        if(params.getNomeMedicinale()!=null)
            medicinaleDto = repository.findByNome(params.getNomeMedicinale());
        else
            medicinaleDto = repository.findById(params.getIdMedicinale());
        if (medicinaleDto.isPresent()){
            return MedicinaleDtoMapper.INSTANCE.toDto(medicinaleDto.get());
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Il medicinale da te indicato non è presente");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    private void checkParamsMedicinale(MedicinaleInfoParams params) {
        if (params.getIdMedicinale()==null || params.getNomeMedicinale()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Inserire un parametro valido.");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public boolean deleteMedicinale(MedicinaleInfoParams params) {
        checkParamsMedicinale(params);
        try {
            if (params.getIdMedicinale()!=null && repository.existsById(params.getIdMedicinale())) {
                repository.deleteById(params.getIdMedicinale());
                return true;
            }else {
                repository.deleteByNome(params.getNomeMedicinale());
                return true;
            }
        }catch (IllegalArgumentException e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Inserire un parametro valido.");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

    }

    public MedicinaleDto addMedicinale(MedicinaleParams params) {
        if(repository.findByNome(params.getNome()).isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Elemento già presente");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else {
            MedicinaleDto toSave = new MedicinaleDto();
            toSave.setNome(params.getNome());
            toSave.setDescrizione(params.getDescrizione());
            toSave.setDosaggio(params.getDosaggio());
            return serviceConverter.addMedicinale(toSave);
        }
    }

    public MedicinaleDto modificaMedicinalle(Integer idMedicinale, MedicinaleParams params) {
        Optional<Medicinale> medicinale = repository.findById(idMedicinale);
        if(medicinale.isPresent()){
            return serviceConverter.modificaMedicinale(medicinale.get(),params);
        }else {
            return null;
        }


    }
}
