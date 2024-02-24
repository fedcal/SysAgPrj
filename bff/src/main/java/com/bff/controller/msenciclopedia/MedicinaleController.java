package com.bff.controller.msenciclopedia;

import com.bff.constants.WebConstants;
import com.bff.dto.msenciclopedia.MedicinaleDto;
import com.bff.dto.msenciclopedia.params.medicinale.MedicinaleInfoParams;
import com.bff.dto.msenciclopedia.params.medicinale.MedicinaleParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msenciclopedia.MedicinaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_ENCICLOPEDIA+"/medicinale")
@Tag(name = "Microservizio enciclopedia", description = "ms-enciclopedia")
public class MedicinaleController {

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MedicinaleService medicinaleService;

    @Operation(summary = "Ottenere la lista dei medicinali",
            description = "Restituisce la lista dei medicinali con le relative informazioni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni trovate"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinaleDto>>> getAllMedicinali(){
        esitoMessaggiRequestContextHolder.setOperationId("getAllMedicinali");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleService.findAllMedicinali()));
    }

    @Operation(summary = "Ottenere le informazioni del medicinale",
            description = "Restituisce le informazioni del medicinale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni del medicinale"),
            @ApiResponse(responseCode = "404", description = "Informazioni non presenti"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> getInfoMedicinale(MedicinaleInfoParams params){
        esitoMessaggiRequestContextHolder.setOperationId("getInfoMedicinale");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleService.findInfoMedicinale(params)));
    }

    @Operation(summary = "Eliminare un medicinale",
            description = "Restituisce l'esito dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicinale eliminato"),
            @ApiResponse(responseCode = "400", description = "Errore, medicinale non eliminato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteMedicinaleId(@ParameterObject MedicinaleInfoParams params){
        esitoMessaggiRequestContextHolder.setOperationId("deleteMedicinaleId");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleService.deleteMedicinaleId(params)));
    }

    @Operation(summary = "Aggiungere le informazioni di un nuovo medicinale",
            description = "Restituisce il medicinale aggiunto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni aggiunte"),
            @ApiResponse(responseCode = "400", description = "Informazioni non aggiunte"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> addMedicinale(@ParameterObject MedicinaleParams params){
        esitoMessaggiRequestContextHolder.setOperationId("addMedicinale");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleService.addMedicinale(params)));
    }

    @Operation(summary = "Modificare le informazioni di un medicinale",
            description = "Restituisce il medicinale modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni modificate"),
            @ApiResponse(responseCode = "400", description = "Informazioni non modificate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value = "/modify/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> modificaMedicinale(@ParameterObject @Schema(description = "Id medicinale")
                                                                                @PathParam("id") Integer idMedicinale,
                                                                                @RequestBody @ParameterObject MedicinaleParams params){
        esitoMessaggiRequestContextHolder.setOperationId("modificaMedicinale");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleService.modificaMedicinale(idMedicinale,params)));
    }
}
