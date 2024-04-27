package com.msmedico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msmedico.controller.GestioneMediciController;
import com.msmedico.dto.MedicoDto;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
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
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static com.msmedico.constants.WebConstants.REST_CONTEX_STRING;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GestioneMediciControllerTest {
    private final String URL = REST_CONTEX_STRING +"/gestione-medici";
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
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/findAll")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertFalse(exception);
        assertThat(responseDto.getPayload().isEmpty()).isFalse();
    }
    @Test
    void statoVisitaCheckParamTestError() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= new GenericResponseDto<List<MedicoDto>>();

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/findAll")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertNull(responseDto.getPayload());
    }

    @Test
    void findMedicoErrror() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/find-medico")
                    ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findMedico");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Inserire almeno un parametro di ricerca.");
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void findMedicoById() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/find-medico")
                    .param("idMedico","1"))
                    .andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getPayload().get(0).getIdMedico()).isEqualTo(1);
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void findMedicoByNome() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/find-medico")
                            .param("nome","Francesco"))
                    .andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getPayload().get(0).getIdMedico()).isEqualTo(1);
    }
    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void findMedicoByCognome() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/find-medico")
                            .param("cognome","De Ceglie")
                            .param("nome","Francesco"))
                    .andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getPayload().get(0).getIdMedico()).isEqualTo(1);
    }
    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void findMedicoByNomeAndCognome() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/find-medico")
                            .param("cognome","De Ceglie"))
                    .andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getPayload().get(0).getIdMedico()).isEqualTo(1);
    }
    @Test
    void findMedicoEmpty() {
        boolean exception = false;
        GenericResponseDto<List<MedicoDto>> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(URL+"/find-medico")
                    .param("cognome","De ")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("findMedico");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessun medico trovato.");
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void deleteById() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.delete(URL+"/delete/1")
                    ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getPayload()).isEqualTo("Medico eliminato");
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void deleteByIdError() {
        boolean exception = false;
        GenericResponseDto<String> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.delete(URL+"/delete/2")
            ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("deleteMedico");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessun medico trovato.");
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void modifyMedico() {
        boolean exception = false;
        GenericResponseDto<MedicoDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put(URL+"/modify")
                    .param("idMedico","1")
                    .param("nuovoNome","Alessandro")
                    .param("nuovoCognome","Alessandro")
                    .param("nuovoTurno","Alessandro")
                    .param("nuovoProfilo","1")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getPayload().getNome()).isEqualTo("Alessandro");
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void modifyMedicoErrorId() {
        boolean exception = false;
        GenericResponseDto<MedicoDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put(URL+"/modify")
                    .param("nuovoNome","Alessandro")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("modifyMedico");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Inserire l'id del medico che si vuole modificare.");
    }
    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void modifyMedicoNessunProfilo() {
        boolean exception = false;
        GenericResponseDto<MedicoDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put(URL+"/modify")
                    .param("idMedico","1")
                    .param("nuovoNome","Alessandro")
                    .param("nuovoCognome","Alessandro")
                    .param("nuovoTurno","Alessandro")
                    .param("nuovoProfilo","2")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("modifyMedico");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessun profilo trovato.");
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void modifyMedicoNessunMedico() {
        boolean exception = false;
        GenericResponseDto<MedicoDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put(URL+"/modify")
                    .param("idMedico","2")
                    .param("nuovoNome","Alessandro")
                    .param("nuovoCognome","Alessandro")
                    .param("nuovoTurno","Alessandro")
                    .param("nuovoProfilo","2")).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        assertThat(responseDto.getEsito().getOperationId()).isEqualTo("modifyMedico");
        assertThat(responseDto.getEsito().getMessaggi().get(0).getSeverita()).isEqualTo(SeveritaMessaggioEnum.ERROR);
        assertThat(responseDto.getEsito().getMessaggi().get(0).getCodMsg()).isEqualTo("Nessun medico trovato.");
    }

    @Test
    @Sql("/sql/gestioneMediciController.sql")
    void addMedico() {
        boolean exception = false;
        GenericResponseDto<MedicoDto> responseDto= null;

        try {
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(URL+"/add")
                    .param("nome","Piergiorgio")
                    .param("profilo","1")
            ).andReturn().getResponse();
            responseDto = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<>() {
            });

        }catch (Exception e){
            exception = true;
        }
        Assertions.assertTrue(exception);
    }
}
