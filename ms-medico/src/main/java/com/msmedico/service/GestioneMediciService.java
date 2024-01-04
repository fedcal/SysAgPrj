package com.msmedico.service;

import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.params.gestionemedici.AddMedicoParams;
import com.msmedico.dto.params.gestionemedici.FindMedicoParams;
import com.msmedico.dto.params.gestionemedici.ModifyMedicoParams;
import com.msmedico.entity.Medico;
import com.msmedico.entity.account.Profilo;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.Messaggio;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.exception.EsitoRuntimeException;
import com.msmedico.mapper.account.profilo.ProfiloDtoMapper;
import com.msmedico.mapper.medico.MedicoDtoMapper;
import com.msmedico.mapper.medico.MedicoEntityMapper;
import com.msmedico.repository.MedicoRepository;
import com.msmedico.repository.account.ProfiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GestioneMediciService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ProfiloRepository profiloRepository;

    public List<MedicoDto> findAll() {
        List<Medico> medici = medicoRepository.findAll();
        if(!medici.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return MedicoDtoMapper.INSTANCE.toDto(medici);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna lista di medici trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findAll");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public List<MedicoDto> findMedico(FindMedicoParams params) {
        List<MedicoDto> listaMedico = new ArrayList<>();

        Optional<Medico> findMedico = medicoRepository.findById(params.getIdMedico());
        if(findMedico.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findMedico");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            listaMedico.add(MedicoDtoMapper.INSTANCE.toDto(findMedico.get()));
        }

        List<Medico> listFindMedico = new ArrayList<>();
        if(params.getNome()!=null && params.getCognome()!=null){
            listFindMedico = medicoRepository.findByNomeAndCognome(params.getNome(),params.getCognome());
        } else if (params.getNome()!=null) {
            listFindMedico = medicoRepository.findByNome(params.getNome());
        } else if (params.getCognome()!=null) {
            listFindMedico = medicoRepository.findByCognome(params.getCognome());
        }

        if(listFindMedico.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findMedico");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            listaMedico = MedicoDtoMapper.INSTANCE.toDto(listFindMedico);
        }

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        return listaMedico;
    }

    public String deleteMedico(Integer id) {
        if(id==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire l'id del medico che si vuole cancellare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteMedico");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        if(!medicoRepository.findById(id).isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteMedico");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            try {
                medicoRepository.deleteById(id);
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                return "Medico eliminato";
            }catch (Exception e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Impossibile eliminare il medico.").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteMedico");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }
    }

    public MedicoDto modifyMedico(ModifyMedicoParams params) {
        if(params.getIdMedico()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire l'id del medico che si vuole modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyMedico");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Medico> medicoFind = medicoRepository.findById(params.getIdMedico());
        if(!medicoFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun medico trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyMedico");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            MedicoDto modifyMedico = MedicoDtoMapper.INSTANCE.toDto(medicoFind.get());
            if(params.getNuovoNome()!=null){
                modifyMedico.setNome(params.getNuovoNome());
            }
            if(params.getNuovoCognome()!=null){
                modifyMedico.setCognome(params.getNuovoCognome());
            }
            if(params.getNuovoTurno()!=null){
                modifyMedico.setTurno(params.getNuovoTurno());
            }

            if(params.getNuovoProfilo()!=null){
                Optional<Profilo> findProfilo = profiloRepository.findById(params.getNuovoProfilo());
                if(findProfilo.isPresent()){
                    modifyMedico.setProfilo(ProfiloDtoMapper.INSTANCE.toDto(findProfilo.get()));
                }else{
                    esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                    esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                            .codMsg("Nessun profilo trovato.").build());
                    esitoMessaggiRequestContextHolder.setOperationId("modifyMedico");
                    throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
                }
            }
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return MedicoDtoMapper.INSTANCE.toDto(medicoRepository.save(MedicoEntityMapper.INSTANCE.toEntity(modifyMedico)));
        }
    }

    public MedicoDto addMedico(AddMedicoParams params) {
        MedicoDto medicoSave = new MedicoDto();

        medicoSave.setNome(params.getNome());
        medicoSave.setCognome(params.getCognome());
        medicoSave.setTurno(params.getTurno());

        Optional<Profilo> profiloFind = profiloRepository.findById(params.getProfilo());
        if(profiloFind.isPresent()){
            medicoSave.setProfilo(ProfiloDtoMapper.INSTANCE.toDto(profiloFind.get()));
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun profilo trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyMedico");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        medicoRepository.save(MedicoEntityMapper.INSTANCE.toEntity(medicoSave));

        return medicoSave;
    }
}
