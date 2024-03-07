package com.mspaziente.service;

import com.mspaziente.dto.PazienteDto;
import com.mspaziente.dto.params.operazionigenerali.AddPazienteParams;
import com.mspaziente.dto.params.operazionigenerali.FindPazienteParams;
import com.mspaziente.dto.params.operazionigenerali.ModificaPazienteParams;
import com.mspaziente.entity.CartellaClinica;
import com.mspaziente.entity.ContattoRiferimento;
import com.mspaziente.entity.Paziente;
import com.mspaziente.entity.Reparto;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.esito.GenericResponseConverter;
import com.mspaziente.esito.Messaggio;
import com.mspaziente.esito.constants.EsitoOperazioneEnum;
import com.mspaziente.esito.constants.SeveritaMessaggioEnum;
import com.mspaziente.exception.EsitoRuntimeException;
import com.mspaziente.mapper.paziente.PazienteDtoMapper;
import com.mspaziente.repository.CartellaClinicaRepository;
import com.mspaziente.repository.ContattoRiferimentoRepository;
import com.mspaziente.repository.PazienteRepository;
import com.mspaziente.repository.RepartoRepository;
import com.mspaziente.repository.account.ProfiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperazioniGeneraliService {


    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private ContattoRiferimentoRepository contattoRiferimentoRepository;

    @Autowired
    private RepartoRepository repartoRepository;

    @Autowired
    private CartellaClinicaRepository cartellaClinicaRepository;
    @Autowired
    private ProfiloRepository profiloRepository;
    ;

    public List<PazienteDto> getAllPazienti() {
        List<Paziente> pazienti = pazienteRepository.findAll();

        if(pazienti.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista paziente vuota.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            List<PazienteDto> pazienteDto = PazienteDtoMapper.INSTANCE.toDto(pazienti);
            return pazienteDto;
        }
    }

    public List<PazienteDto> findInfoPazienti(FindPazienteParams params) {
        checkParams(params);
        List<Paziente> findPaziente = new ArrayList<>();

        if(params.getIdPaziente()!=null){
            Optional<Paziente> findById = pazienteRepository.findById(params.getIdPaziente());
            if(findById.isPresent()){
                findPaziente.add(findById.get());
            }
        }

        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome()) && StringUtils.hasLength(params.getDataNascita())){
            findPaziente.addAll(pazienteRepository.findByNomeAndCognomeAndData(params.getNome(),params.getCognome(),params.getDataNascita()));
        }

        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome())){
            findPaziente.addAll(pazienteRepository.findByNomeAndCognome(params.getNome(),params.getCognome()));
        }

        if(StringUtils.hasLength(params.getNome())){
            findPaziente.addAll(pazienteRepository.findByNome(params.getNome()));
        }

        if(StringUtils.hasLength(params.getCognome())){
            findPaziente.addAll(pazienteRepository.findByCognome(params.getCognome()));
        }

        if(StringUtils.hasLength(params.getDataNascita())){
            findPaziente.addAll(pazienteRepository.findByDataNascita(params.getDataNascita()));
        }
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
        return PazienteDtoMapper.INSTANCE.toDto(findPaziente);
    }

    private void checkParams(FindPazienteParams params) {
        if(params.getIdPaziente()==null && !StringUtils.hasLength(params.getNome()) && !StringUtils.hasLength(params.getCognome()) && !StringUtils.hasLength(params.getDataNascita())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public PazienteDto addInfoPazienti(AddPazienteParams params) {
        checkParams(params);
        Paziente pazienteToSave = new Paziente();
        pazienteToSave.setNome(params.getNome());
        pazienteToSave.setCognome(params.getCognome());
        pazienteToSave.setDataNascita(params.getDataNascita());
        pazienteToSave.setLuogoNascita(params.getLuogoNascita());
        pazienteToSave.setProvinciaNascita(params.getProvinciaNascita());
        pazienteToSave.setProfilo(profiloRepository.findById(4).get());

        Optional<ContattoRiferimento> contattoRiferimentoFind = contattoRiferimentoRepository.findById(params.getIdContattoRiferimento());

        if(!contattoRiferimentoFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Contatto di riferimento non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("addInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Reparto> repartoFind = repartoRepository.findById(params.getIdReparto());

        if(!repartoFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Reparto non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("addInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<CartellaClinica> cartellaClinicaFind = cartellaClinicaRepository.findById(params.getIdCartellaClinica());

        if(!cartellaClinicaFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Cartella clinica non trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("addInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        pazienteToSave.setContattoRiferimento(contattoRiferimentoFind.get());
        pazienteToSave.setReparto(repartoFind.get());
        pazienteToSave.setCartellaClinica(cartellaClinicaFind.get());

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
        return  PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.save(pazienteToSave));
    }

    private void checkParams(AddPazienteParams params) {
        boolean checkId = params.getIdCartellaClinica()==null && params.getIdReparto()==null
                            && params.getIdContattoRiferimento()==null;
        boolean checkString = !StringUtils.hasLength(params.getNome()) && !StringUtils.hasLength(params.getCognome()) &&
                                !StringUtils.hasLength(params.getLuogoNascita()) && !StringUtils.hasLength(params.getProvinciaNascita()) &&
                                !StringUtils.hasLength(params.getDataNascita());
        if(checkId && checkString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire tutti i parametri.").build());
            esitoMessaggiRequestContextHolder.setOperationId("addInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteInfoPazienti(Integer idPaziente) {
        try {
            pazienteRepository.deleteById(idPaziente);
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            return "Paziente eliminato";
        }catch (Exception e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            return "Paziente non eliminato";
        }
    }

    public PazienteDto modificaInfoPazienti(ModificaPazienteParams params) {
        checkParams(params);
        Optional<Paziente> pazienteFind = pazienteRepository.findById(params.getIdPaziente());
        if(!pazienteFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Paziente da modificare non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modificaInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        if(StringUtils.hasLength(params.getNuvoNome())){
            pazienteFind.get().setNome(params.getNuvoNome());
        }

        if(StringUtils.hasLength(params.getNuovoCognome())){
            pazienteFind.get().setCognome(params.getNuovoCognome());
        }

        if(StringUtils.hasLength(params.getNuovaDataNascita())){
            pazienteFind.get().setDataNascita(params.getNuovaDataNascita());
        }

        if(StringUtils.hasLength(params.getNuovoLuogoNascita())){
            pazienteFind.get().setLuogoNascita(params.getNuovoLuogoNascita());
        }

        if(StringUtils.hasLength(params.getNuovaProvinciaNascita())){
            pazienteFind.get().setProvinciaNascita(params.getNuovaProvinciaNascita());
        }

        if(params.getIdContattoRiferimento()!=null){
            Optional<ContattoRiferimento> contattoRiferimentoFind = contattoRiferimentoRepository.findById(params.getIdContattoRiferimento());
            if(contattoRiferimentoFind.isPresent()){
                pazienteFind.get().setContattoRiferimento(contattoRiferimentoFind.get());
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Contatto riferimento da modificare non trovato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("modificaInfoPazienti");
                throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
            }
        }

        if(params.getIdReparto()!=null){
            Optional<Reparto> repartoFind = repartoRepository.findById(params.getIdReparto());
            if(repartoFind.isPresent()){
                pazienteFind.get().setReparto(repartoFind.get());
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Reparto da modificare non trovato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("modificaInfoPazienti");
                throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
            }
        }

        if(params.getIdCartellaClinica()!=null){
            Optional<CartellaClinica> cartellaClinicaFind = cartellaClinicaRepository.findById(params.getIdReparto());
            if(cartellaClinicaFind.isPresent()){
                pazienteFind.get().setCartellaClinica(cartellaClinicaFind.get());
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Cartella clinica non trovata.").build());
                esitoMessaggiRequestContextHolder.setOperationId("modificaInfoPazienti");
                throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
            }
        }

        return PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.save(pazienteFind.get()));
    }

    private void checkParams(ModificaPazienteParams params) {
        boolean checkId = params.getIdCartellaClinica()==null && params.getIdReparto()==null
                && params.getIdContattoRiferimento()==null;
        boolean checkString = !StringUtils.hasLength(params.getNuovoCognome()) && !StringUtils.hasLength(params.getNuovoCognome()) &&
                !StringUtils.hasLength(params.getNuovaDataNascita()) && !StringUtils.hasLength(params.getNuovoLuogoNascita()) &&
                !StringUtils.hasLength(params.getNuovaProvinciaNascita());
        if(params.getIdPaziente()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire l'id del paziente da modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modificaInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        if(checkId && checkString){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro da modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modificaInfoPazienti");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
