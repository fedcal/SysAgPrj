package com.bff.service.msmedico;

import com.bff.dto.msinfo.InfermiereDto;
import com.bff.dto.msmedico.MedicoDto;
import com.bff.dto.msmedico.params.gestionemedici.AddMedicoParams;
import com.bff.dto.msmedico.params.gestionemedici.FindMedicoParams;
import com.bff.dto.msmedico.params.gestionemedici.ModifyMedicoParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msmedico.api.GestioneMediciControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestioneMediciService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private GestioneMediciControllerApi gestioneMediciControllerApi;

    public List<MedicoDto> findAll() {
        GenericResponseDto<List<MedicoDto>> listaMedici = genericResponseConverter.convertGenericResponseList(
                gestioneMediciControllerApi.msMedicoGetAllMedico(), MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }

    public List<MedicoDto> findMedico(FindMedicoParams params) {
        GenericResponseDto<List<MedicoDto>> listaMedici = genericResponseConverter.convertGenericResponseList(
                gestioneMediciControllerApi.msMedicoFindMedico(params.getIdMedico(), params.getNome(), params.getCognome()), MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }

    public String deleteMedico(Integer id) {
        GenericResponseDto<String> listaMedici = genericResponseConverter.convertGenericResponse(
                gestioneMediciControllerApi.msMedicoDeleteMedico(id), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }

    public MedicoDto modifyMedico(ModifyMedicoParams params) {
        GenericResponseDto<MedicoDto> listaMedici = genericResponseConverter.convertGenericResponse(
                gestioneMediciControllerApi.msMedicoModifyMedico(params.getIdMedico(),params.getNuovoNome(), params.getNuovoCognome(), params.getNuovoTurno(), params.getNuovoProfilo()), MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }

    public MedicoDto addMedico(AddMedicoParams params) {
        GenericResponseDto<MedicoDto> listaMedici = genericResponseConverter.convertGenericResponse(
                gestioneMediciControllerApi.msMedicoAddMedico(params.getNome(), params.getCognome(), params.getTurno(), params.getProfilo()), MedicoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }
}
