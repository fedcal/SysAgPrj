package com.bff.controller.msenciclopedia;

import com.bff.constants.WebConstants;

import com.bff.dto.msenciclopedia.MalattiaDto;
import com.bff.dto.msenciclopedia.params.malattia.MalattiaChangeInfoParams;
import com.bff.dto.msenciclopedia.params.malattia.MalattiaInfoParams;
import com.bff.dto.msenciclopedia.params.malattia.MalattiaParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.esito.costants.EsitoOperazioneEnum;
import com.bff.service.msenciclopedia.MalattieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_ENCICLOPEDIA+"/malattie")
public class MalattieController {

    @Autowired
    private MalattieService malattieService;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Recuperare le informazioni di tutte le malattie",
            description = "Restituisce le informazioni di tutte le malattie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupero informazioni andato a buon fine"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MalattiaDto>>> getAllMalattie(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllMalattie");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.findAllMalattie()));
    }

    @Operation(summary = "Recuperare le informazioni della malattia selezionata",
            description = "Restituisce le informazioni della malattia selezionata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupero informazioni andato a buon fine"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping("/info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> getMalattiaInfo(@ParameterObject MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getMalattiaInfo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.findMalattiaInfo(params)));
    }

    @Operation(summary = "Aggiungere le informazioni di una nuova malattia",
            description = "Restituisce la malattia aggiunta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni aggiunte"),
            @ApiResponse(responseCode = "400", description = "Informazioni non aggiunte"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping("/add")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> addMalattia(@ParameterObject MalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.addMalattia(params)));
    }

    @Operation(summary = "Modificare le informazioni di una malattia",
            description = "Restituisce le informazioni modificate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni modificate correttamente"),
            @ApiResponse(responseCode = "400", description = "Informazioni non modificate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping("/change-info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> changeInfoMalattia(@ParameterObject MalattiaChangeInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("changeInfoMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.changeInfoMalattia(params)));

    }

    @Operation(summary = "Elimina una malattia",
            description = "Restituisce l'esito della cancellazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restituisce l'esito dell'operazione"),
            @ApiResponse(responseCode = "400", description = "Operazione non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<GenericResponseDto<String>> deleteMalattia(@ParameterObject MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.deleteMalattia(params)));
    }

}
