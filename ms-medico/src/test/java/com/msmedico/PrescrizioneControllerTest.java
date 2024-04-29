package com.msmedico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
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
public class PrescrizioneControllerTest {
    private final String URL = REST_CONTEX_STRING +"/prescrizione";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void prescriviOperazioneInfoError() {
        boolean exception = false;
        GenericResponseDto<List<OperazionePrescrizioneDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/operazione-info")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("prescriviOperazioneInfo");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Inserire almeno un parametro di ricerca.");
    }

    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void prescriviOperazioneInfoNessunaOperazione() {
        boolean exception = false;
        GenericResponseDto<List<OperazionePrescrizioneDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/operazione-info")
                    .param("idMedico","8")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("prescriviOperazioneInfo");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessuna operazione trovata.");
    }

    @Test
    @Sql("/sql/pazienteControllerTest.sql")
    void prescriviOperazioneInfoIdMedico() {
        boolean exception = false;
        GenericResponseDto<List<OperazionePrescrizioneDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/operazione-info")
                    .param("idCartella","1")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("prescriviOperazioneInfo");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessuna operazione trovata.");
    }
}
