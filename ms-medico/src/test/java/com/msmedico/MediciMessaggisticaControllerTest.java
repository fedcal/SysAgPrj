package com.msmedico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.msinfermiere.api.MsInfermieriMessaggisticaControllerApi;
import com.msmedico.msinfermiere.model.Esito;
import com.msmedico.msinfermiere.model.GenericResponseDtoString;
import com.msmedico.mspaziente.api.MsPazientiMessaggisticaControllerApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.msmedico.constants.WebConstants.REST_CONTEX_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MediciMessaggisticaControllerTest {
    private final String URL = REST_CONTEX_STRING +"/messagistica";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MsInfermieriMessaggisticaControllerApi messaggisticaControllerApiInfermiere;

    @MockBean
    private MsPazientiMessaggisticaControllerApi pazientiMessaggisticaControllerApi;

    @Test
    void statoVisitaCheckParamTest() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            when(messaggisticaControllerApiInfermiere.msInfermiereRiceviMessaggioMedico(anyString(), anyString())).thenReturn(createGenericResponseDtoString());
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/invio-infermiere")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","LOW")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }

    @Test
    void riceviMessaggioInfermiereTestLow() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-infermiere")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","LOW")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }
    @Test
    void riceviMessaggioInfermiereTestHigh() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-infermiere")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","HIGH")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }
    @Test
    void riceviMessaggioInfermiereTestMedium() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-infermiere")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","MEDIUM")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }

    @Test
    void riceviMessaggioInfermiereTestNoUrgenza() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-infermiere")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }

    @Test
    void invioPaziente() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            when(pazientiMessaggisticaControllerApi.msPazienteRiceviMessaggioMedico(anyString(), anyString())).thenReturn(createGenericResponseDtoStringPaziente());
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/invio-paziente")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","LOW")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }

    @Test
    void invioPazienteTestLow() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-paziente")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","LOW")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }
    @Test
    void invioPazienteTestMedium() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-paziente")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","MEDIUM")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }
    @Test
    void invioPazienteTestHigh() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-paziente")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","HIGH")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }
    @Test
    void invioPazienteTestNoUrgenza() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/ricevi-paziente")
                    .param("messaggio","Ciao")
                    .param("livelloUrgenza","")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload()).isEqualTo("Messaggio ricevuto");
    }

    private com.msmedico.mspaziente.model.GenericResponseDtoString createGenericResponseDtoStringPaziente() {
        com.msmedico.mspaziente.model.GenericResponseDtoString
                genericResponseDtoString = new com.msmedico.mspaziente.model.GenericResponseDtoString();
        genericResponseDtoString.setEsito(new com.msmedico.mspaziente.model.Esito());
        genericResponseDtoString.getEsito().setMessaggi(new ArrayList<>());
        genericResponseDtoString.setPayload("Messaggio ricevuto");
        return genericResponseDtoString;
    }

    private GenericResponseDtoString createGenericResponseDtoString() {
        GenericResponseDtoString genericResponseDtoString = new GenericResponseDtoString();
        genericResponseDtoString.setEsito(new Esito());
        genericResponseDtoString.getEsito().setMessaggi(new ArrayList<>());
        genericResponseDtoString.setPayload("Messaggio ricevuto");
        return genericResponseDtoString;
    }

}
