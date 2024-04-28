package com.msmedico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.output.CartellaClinicaOutputDto;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.msmedico.constants.WebConstants.REST_CONTEX_STRING;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PazienteControllerTest {
    private final String URL = REST_CONTEX_STRING +"/pazienti";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void statoVisitaCheckParamTest() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/lista-pazienti")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload().isEmpty()).isFalse();
    }
    @Test
    void statoVisitaCheckParamTestVuota() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/lista-pazienti")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("getAllPazienti");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Lista paziente vuota.");
    }

    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findInfoPazientiErrorParams() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/info-paziente")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findInfoPazienti");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Inserire almeno un parametro di ricerca.");
    }
    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findInfoPazientiFindId() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/info-paziente")
                    .param("idPaziente","1")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findInfoPazienti");
        assertThat(responseDto.getPayload().isEmpty()).isFalse();
    }
    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findInfoPazientiFindNome() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/info-paziente")
                    .param("nome","Giuseppe")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findInfoPazienti");
        assertThat(responseDto.getPayload().isEmpty()).isFalse();
    }
    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findInfoPazientiFindCognome() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/info-paziente")
                    .param("cognome","Garibaldi")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findInfoPazienti");
        assertThat(responseDto.getPayload().isEmpty()).isFalse();
    }
    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findInfoPazientiFindNomeCognome() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/info-paziente")
                    .param("nome","Giuseppe")
                    .param("cognome","Garibaldi")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findInfoPazienti");
        assertThat(responseDto.getPayload().isEmpty()).isFalse();
    }
    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findInfoPazientiFindNomeCognomeData() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/info-paziente")
                    .param("dataNascita","07-05-2005")
                    .param("nome","Giuseppe")
                    .param("cognome","Garibaldi")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findInfoPazienti");
        assertThat(responseDto.getPayload().isEmpty()).isFalse();
    }

    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findCartellaClinicaTestNoParams() {
        boolean exception = false;
        GenericResponseDto<CartellaClinicaOutputDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/trova-cartella")
            ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findCartellaClinica");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Inserire almeno un parametro di ricerca.");
    }
    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findCartellaClinicaTestNoUtente() {
        boolean exception = false;
        GenericResponseDto<CartellaClinicaOutputDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/trova-cartella")
                    .param("idPaziente","3")
            ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findCartellaClinica");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessun paziente trovato.");
    }

    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findCartellaClinicaTestNessunaCartella() {
        boolean exception = false;
        GenericResponseDto<CartellaClinicaOutputDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/trova-cartella")
                    .param("idPaziente","1")
            ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findCartellaClinica");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessuna cartella clinica trovata.");
    }
    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void findCartellaClinicaTestCartellaTrovata() {
        boolean exception = false;
        GenericResponseDto<CartellaClinicaOutputDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/trova-cartella")
                    .param("idPaziente","2")
            ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getPayload().getDiagnosi().isEmpty()).isFalse();
    }
}
