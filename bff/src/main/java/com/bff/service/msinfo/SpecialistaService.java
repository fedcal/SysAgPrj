package com.bff.service.msinfo;

import com.bff.dto.msinfo.SpecialistaDto;
import com.bff.dto.msinfo.params.specialista.AddSpecialistaParams;
import com.bff.dto.msinfo.params.specialista.FindSpecialistaParams;
import com.bff.dto.msinfo.params.specialista.ModifySpecialistaParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.info.api.SpecialistaControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistaService {
    @Autowired
    private SpecialistaControllerApi specialistaControllerApi;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    public List<SpecialistaDto> findAll() {
        GenericResponseDto<List<SpecialistaDto>> findAll = genericResponseConverter.convertGenericResponseList(
                specialistaControllerApi.getAllSpecialista(),SpecialistaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findAll.getEsito().getMessaggi());
        return findAll.getPayload();
    }

    public List<SpecialistaDto> findSpecialista(FindSpecialistaParams params) {
        GenericResponseDto<List<SpecialistaDto>> findSpecialista = genericResponseConverter.convertGenericResponseList(
                specialistaControllerApi.findSpecialista(params.getIdSpecialista(), params.getNome(), params.getCognome()),
                SpecialistaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findSpecialista.getEsito().getMessaggi());
        return findSpecialista.getPayload();
    }

    public String deleteSpecialista(Integer id) {
        GenericResponseDto<String> deleteSpecialista = genericResponseConverter.convertGenericResponse(
                specialistaControllerApi.deleteSpecialista(id),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(deleteSpecialista.getEsito().getMessaggi());
        return deleteSpecialista.getPayload();
    }

    public SpecialistaDto modifySpecialista(ModifySpecialistaParams params) {
        GenericResponseDto<SpecialistaDto> modifySpecialista = genericResponseConverter.convertGenericResponse(
                specialistaControllerApi.modifySpecialista(params.getIdSpecialista(), params.getNuovoNome(), params.getNuovoCognome(),
                        params.getNuovaSpecializzazione(), params.getNuovoTurno(), params.getNuovoProfilo()),SpecialistaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(modifySpecialista.getEsito().getMessaggi());
        return modifySpecialista.getPayload();
    }

    public SpecialistaDto addSpecialista(AddSpecialistaParams params) {
        GenericResponseDto<SpecialistaDto> addSpecialista = genericResponseConverter.convertGenericResponse(
                specialistaControllerApi.addSpecialista(params.getNome(), params.getCognome(), params.getSpecializzazione(), params.getTurno(), params.getProfilo()),SpecialistaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(addSpecialista.getEsito().getMessaggi());
        return addSpecialista.getPayload();
    }
}
