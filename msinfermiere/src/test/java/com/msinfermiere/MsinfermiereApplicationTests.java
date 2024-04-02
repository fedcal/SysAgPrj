package com.msinfermiere;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.dto.params.operazionigenerali.InfermiereAddParams;
import com.msinfermiere.dto.paziente.PazienteDto;
import com.msinfermiere.service.OperazioniGeneraliService;
import com.msinfermiere.service.PazienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
class MsinfermiereApplicationTests {
	@Autowired
	private PazienteService pazienteService;

	@Test
	@Sql("/sql/pazienteService.sql")
	void contextLoads() {
		List<PazienteDto> pazienti = pazienteService.getAllPazienti();
		assertThat(pazienti).isNotEmpty();
	}

}
