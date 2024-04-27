package com.msmedico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msmedico.controller.GestioneMediciController;
import com.msmedico.dto.MedicoDto;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.GenericResponseDto;
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
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static com.msmedico.constants.WebConstants.REST_CONTEX_STRING;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GestioneMediciControllerTest {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private GestioneMediciController gestioneMediciController;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void statoVisitaCheckParamTest() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            gestioneMediciController.getAllMedico();
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(REST_CONTEX_STRING +"/gestione-medici"+"/findAll")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload().isEmpty()).isFalse();

    }
}
