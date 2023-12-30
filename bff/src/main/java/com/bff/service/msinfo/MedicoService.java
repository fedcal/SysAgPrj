package com.bff.service.msinfo;

import com.bff.dto.msinfo.MedicoDto;
import com.bff.dto.msinfo.params.medico.AddMedicoParams;
import com.bff.dto.msinfo.params.medico.FindMedicoParams;
import com.bff.dto.msinfo.params.medico.ModifyMedicoParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.info.api.MedicoControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoControllerApi medicoControllerApi;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    public List<MedicoDto> findAll() {
        GenericResponseDto<List<MedicoDto>> listaMedici = genericResponseConverter.convertGenericResponseList(
                medicoControllerApi.getAllMedico(),MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }

    public List<MedicoDto> findMedico(FindMedicoParams params) {
        GenericResponseDto<List<MedicoDto>> findMedico = genericResponseConverter.convertGenericResponseList(
                medicoControllerApi.findMedico(params.getIdMedico(), params.getNome(), params.getCognome()),MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findMedico.getEsito().getMessaggi());
        return findMedico.getPayload();
    }

    public String deleteMedico(Integer id) {
        GenericResponseDto<String> deleteMedico = genericResponseConverter.convertGenericResponse(
                medicoControllerApi.deleteMedico(id),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(deleteMedico.getEsito().getMessaggi());
        return deleteMedico.getPayload();
    }

    public MedicoDto modifyMedico(ModifyMedicoParams params) {
        GenericResponseDto<MedicoDto> deleteMedico = genericResponseConverter.convertGenericResponse(
                medicoControllerApi.modifyMedico(params.getIdMedico(), params.getNuovoNome(), params.getNuovoCognome(),
                        params.getNuovoTurno(), params.getNuovoProfilo()),MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(deleteMedico.getEsito().getMessaggi());
        return deleteMedico.getPayload();
    }

    public MedicoDto addMedico(AddMedicoParams params) {
        GenericResponseDto<MedicoDto> addMedico = genericResponseConverter.convertGenericResponse(
                medicoControllerApi.addMedico(params.getNome(), params.getCognome(), params.getTurno(), params.getProfilo())
                ,MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(addMedico.getEsito().getMessaggi());
        return addMedico.getPayload();
    }
}
