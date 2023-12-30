package com.bff.service.msinfo;

import com.bff.dto.msinfo.PazienteDto;
import com.bff.dto.msinfo.params.paziente.AddPazienteParams;
import com.bff.dto.msinfo.params.paziente.ModificaPazienteParams;
import com.bff.dto.msinfo.params.paziente.SearchPazienteParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.info.api.PazienteControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PazienteService {
    @Autowired
    private PazienteControllerApi pazienteControllerApi;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    public List<PazienteDto> findAll() {
        GenericResponseDto<List<PazienteDto>> findAll = genericResponseConverter.convertGenericResponseList(
                pazienteControllerApi.getAllPaziente(),PazienteDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findAll.getEsito().getMessaggi());
        return findAll.getPayload();
    }

    public List<PazienteDto> searchPaziente(SearchPazienteParams params) {
        GenericResponseDto<List<PazienteDto>> searchPaziente = genericResponseConverter.convertGenericResponseList(
                pazienteControllerApi.searchPaziente(params.getIdPaziente(), params.getNome(), params.getCognome(),
                        params.getDataNascita(), params.getNomeReparto(), params.getContattoRiferimentoDto()),
                PazienteDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(searchPaziente.getEsito().getMessaggi());
        return searchPaziente.getPayload();
    }

    public String deleteById(Integer id) {
        GenericResponseDto<String> deleteById = genericResponseConverter.convertGenericResponse(
                pazienteControllerApi.deletePaziente(id),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(deleteById.getEsito().getMessaggi());
        return deleteById.getPayload();
    }

    public PazienteDto addPaziente(AddPazienteParams params) {
        GenericResponseDto<PazienteDto> addPaziente = genericResponseConverter.convertGenericResponse(
                pazienteControllerApi.addPaziente(params.getNome(), params.getCognome(), params.getDataNascita(),
                        params.getLuogoNascita(), params.getProvinciaNascita(), params.getContattoRiferimentoId(),
                        params.getRepartoId()),PazienteDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(addPaziente.getEsito().getMessaggi());
        return addPaziente.getPayload();
    }

    public PazienteDto modificaPaziente(ModificaPazienteParams params) {
        GenericResponseDto<PazienteDto> modificaPaziente = genericResponseConverter.convertGenericResponse(
                pazienteControllerApi.modifyPaziente(params.getIdPazinente(), params.getNuovoNome(), params.getNuovoCognome(),
                        params.getNuovaDataNascita(), params.getNuovoLuogoNascita(), params.getNuovaProvinciaNascita(),
                        params.getNuovoContattoRiferimentoId(), params.getNuovoRepartoId()),PazienteDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(modificaPaziente.getEsito().getMessaggi());
        return modificaPaziente.getPayload();
    }
}
