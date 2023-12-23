package com.msinfo.service;

import com.msinfo.dto.ContattoRiferimentoDto;
import com.msinfo.dto.PazienteDto;
import com.msinfo.dto.RepartoDto;
import com.msinfo.dto.params.paziente.AddPazienteParams;
import com.msinfo.dto.params.paziente.ModificaPazienteParams;
import com.msinfo.dto.params.paziente.PazienteSearchParams;
import com.msinfo.entity.pazienti.ContattoRiferimento;
import com.msinfo.entity.pazienti.Paziente;
import com.msinfo.entity.reparto.Reparto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.account.profilo.ProfiloDtoMapper;
import com.msinfo.mapper.pazienti.contattoriferimento.ContattoRiferimentoDtoMapper;
import com.msinfo.mapper.pazienti.paziente.PazienteDtoMapper;
import com.msinfo.mapper.pazienti.paziente.PazienteEntityMapper;
import com.msinfo.mapper.reparto.RepartoDtoMapper;
import com.msinfo.repository.ContattoRiferimentoRepository;
import com.msinfo.repository.PazienteRepository;
import com.msinfo.repository.ProfiloRepository;
import com.msinfo.repository.RepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PazienteService {
    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private ProfiloRepository profiloRepository;

    @Autowired
    private ContattoRiferimentoRepository contattoRiferimentoRepository;

    @Autowired
    private RepartoRepository repartoRepository;

    public List<PazienteDto> findAll(){
        List<PazienteDto> listaPazienti = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findAll());
        if(listaPazienti.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Non sono stati trovati pazienti all'interno dell'ospedale").build());
            esitoMessaggiRequestContextHolder.setOperationId("findAll");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                .codMsg("Elenco pazienti").build());
        esitoMessaggiRequestContextHolder.setOperationId("findAll");
        return PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findAll());
    }

    public List<PazienteDto> searchPaziente(PazienteSearchParams params) {
        List<PazienteDto> pazienteDtoList = null;

        if(params.getNome()!=null && params.getCognome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByNomeAndCognome(params.getNome(),params.getCognome()));
        }

        if(params.getIdPaziente()!=null){
            pazienteDtoList = Collections.singletonList(PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findById(params.getIdPaziente()).get()));
        }

        if (params.getNome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByNome(params.getNome()));
        }

        if (params.getCognome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByCognome(params.getCognome()));
        }

        if(params.getDataNascita()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByDataNascita(params.getDataNascita()));
        }

        if(params.getContattoRiferimentoDto().getIdContatto()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByIdContatto(params.getContattoRiferimentoDto().getIdContatto()));
        }

        if(params.getContattoRiferimentoDto().getNome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByNomeContatto(params.getContattoRiferimentoDto().getNome()));
        }

        if(params.getContattoRiferimentoDto().getCognome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByCognomeContatto(params.getContattoRiferimentoDto().getCognome()));
        }

        if(params.getContattoRiferimentoDto().getNumeroCellulare()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByContattoNumeroCellulare(params.getContattoRiferimentoDto().getNumeroCellulare()));
        }

        if (pazienteDtoList == null || pazienteDtoList.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Non sono stati trovati pazienti corrispondenti ai parametri di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("searchPaziente");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista di pazienti").build());
            esitoMessaggiRequestContextHolder.setOperationId("searchPaziente");
            return pazienteDtoList;
        }
    }

    public String deleteById(Integer id) {
        if(!pazienteRepository.findById(id).isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun paziente trovato").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteById");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        try{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Paziente eliminato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteById");
            pazienteRepository.deleteById(id);
            return "Paziente eliminato";
        }catch (IllegalArgumentException e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Impossibile eliminare il paziente.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteById");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public PazienteDto addPaziente(AddPazienteParams params) {
        checkPazientePresente(params);

        PazienteDto savedDto = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.save(PazienteEntityMapper.INSTANCE.toEntity(mappPazienteDto(params))));

        return savedDto;
    }

    private PazienteDto mappPazienteDto(AddPazienteParams params) {
        PazienteDto returnDto = new PazienteDto();

        returnDto.setIdPaziente(pazienteRepository.findAll().size()+1);
        returnDto.setNome(params.getNome());
        returnDto.setCognome(params.getCognome());
        returnDto.setDataNascita(params.getDataNascita());
        returnDto.setLuogoNascita(params.getLuogoNascita());
        returnDto.setProvinciaNascita(params.getProvinciaNascita());

        returnDto.setProfilo(ProfiloDtoMapper.INSTANCE.toDto(profiloRepository.findById(4).get()));

        if(params.getContattoRiferimentoId()!=null){
            Optional<ContattoRiferimento> contattoRiferimentoFind = contattoRiferimentoRepository.findById(params.getContattoRiferimentoId());
            if(contattoRiferimentoFind.isPresent()) {
                returnDto.setContattoRiferimento(ContattoRiferimentoDtoMapper.INTERFACE.toDto(contattoRiferimentoFind.get()));
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Nessun contatto di riferimento trovato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteById");
            }
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire il contatto di riferimento.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteById");
        }

        if(params.getRepartoId()!=null ){
            Optional<Reparto> repartoFind = repartoRepository.findById(params.getRepartoId());
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire l'id del reparto.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteById");
        }
        return returnDto;
    }

    private void checkPazientePresente(AddPazienteParams params) {
        List<PazienteDto> listaPazienti = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByCognome(params.getCognome()));
        boolean alreadyExists = false;

        if (listaPazienti.isEmpty())
            return;

        for (PazienteDto e : listaPazienti){
            boolean checkNome = params.getNome().equals(e.getNome());
            boolean checkDataNascita = params.getDataNascita().equals(e.getDataNascita());
            boolean checkLuogoNascita = params.getLuogoNascita().equals(e.getLuogoNascita());
            if(checkNome && checkDataNascita && checkLuogoNascita){
                alreadyExists = true;
            }
        }

        if(alreadyExists){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Impossibile aggiungere il paziente in quanto già presente.").build());
            esitoMessaggiRequestContextHolder.setOperationId("addPaziente");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public PazienteDto modificaPaziente(ModificaPazienteParams params) {
        PazienteDto findPaziente = checkPazientePresente(params);
        if(params.getNuovoNome()!=null){
            findPaziente.setNome(params.getNuovoNome());
        }
        if(params.getNuovoCognome()!=null){
            findPaziente.setCognome(params.getNuovoCognome());
        }
        if(params.getNuovaDataNascita()!=null){
            findPaziente.setDataNascita(params.getNuovaDataNascita());
        }
        if(params.getNuovoLuogoNascita()!=null){
            findPaziente.setLuogoNascita(params.getNuovoLuogoNascita());
        }
        if(params.getNuovaProvinciaNascita()!=null){
            findPaziente.setProvinciaNascita(params.getNuovaProvinciaNascita());
        }
        if(params.getNuovoContattoRiferimentoId()!=null){
            ContattoRiferimentoDto contattoRiferimentoDto = checkContattoRiferimento(params.getNuovoContattoRiferimentoId());
            findPaziente.setContattoRiferimento(contattoRiferimentoDto);
        }
        if(params.getNuovoRepartoId()!=null){
            RepartoDto nuovoReparto = checkReparto(params.getNuovoRepartoId());
            findPaziente.setReparto(nuovoReparto);
        }
        return PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.save(PazienteEntityMapper.INSTANCE.toEntity(findPaziente)));
    }

    private RepartoDto checkReparto(Integer nuovoRepartoId) {
        Optional<Reparto> findReparto = repartoRepository.findById(nuovoRepartoId);;
        if(!findReparto.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Reparto non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modificaPaziente");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else {
            return RepartoDtoMapper.INSTANCE.toDto(findReparto.get());
        }
    }

    private ContattoRiferimentoDto checkContattoRiferimento(Integer nuovoContattoRiferimentoId) {
        Optional<ContattoRiferimento> contattoRiferimento =  contattoRiferimentoRepository.findById(nuovoContattoRiferimentoId);
        if(!contattoRiferimento.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Contatto di riferimento non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modificaPaziente");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else{
            return ContattoRiferimentoDtoMapper.INTERFACE.toDto(contattoRiferimento.get());
        }
    }

    private PazienteDto checkPazientePresente(ModificaPazienteParams params){
        Optional<Paziente> findPaziente = pazienteRepository.findById(params.getIdPazinente());
        if (!findPaziente.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Paziente da modificare non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modificaPaziente");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else{
            return PazienteDtoMapper.INSTANCE.toDto(findPaziente.get());
        }

    }
}
