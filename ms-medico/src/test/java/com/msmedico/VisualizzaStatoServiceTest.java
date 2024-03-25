package com.msmedico;

import com.msmedico.dto.params.visualizzastato.FindStatoVisitaMedicaParams;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.service.VisualizzaStatoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class VisualizzaStatoServiceTest {
	@Autowired
	private VisualizzaStatoService visualizzaStatoService;

	@Autowired
	private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

	@Test
	void statoVisitaCheckParamTest() {
		FindStatoVisitaMedicaParams findStatoVisitaMedicaParams = new FindStatoVisitaMedicaParams();
		boolean exception = false;

		try {
			visualizzaStatoService.statoVisita(findStatoVisitaMedicaParams);
		}catch (Exception e){
			exception = true;
		}

		Assertions.assertTrue(exception);
		Assertions.assertEquals(esitoMessaggiRequestContextHolder.getCodRet(), EsitoOperazioneEnum.KO);
		Assertions.assertEquals(esitoMessaggiRequestContextHolder.getOperationId(),"statoVisita");
		Assertions.assertEquals(esitoMessaggiRequestContextHolder.getMessaggi().get(0).getSeverita(), SeveritaMessaggioEnum.ERROR);
		Assertions.assertEquals(esitoMessaggiRequestContextHolder.getMessaggi().get(0).getCodMsg(), "Inserire almeno un parametro di ricerca.");
	}

}
