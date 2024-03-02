package com.msinfo.service;

import com.msinfo.dto.MedicoDto;
import com.msinfo.dto.params.medico.AddMedicoParams;
import com.msinfo.dto.params.medico.FindMedicoParams;
import com.msinfo.dto.params.medico.ModifyMedicoParams;
import com.msinfo.entity.account.Profilo;
import com.msinfo.entity.medici.Medico;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.account.profilo.ProfiloDtoMapper;
import com.msinfo.mapper.medici.MedicoDtoMapper;
import com.msinfo.mapper.medici.MedicoEntityMapper;
import com.msinfo.repository.MedicoRepository;
import com.msinfo.repository.ProfiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ProfiloRepository profiloRepository;


    public List<MedicoDto> findAll() {
        List<MedicoDto> listaMedici = MedicoDtoMapper.INSTANCE.toDto(medicoRepository.findAll());
        if (listaMedici.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna lista di medici trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findAll");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return listaMedici;
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
        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome())){
            listFindMedico = medicoRepository.findByNomeAndCognome(params.getNome(),params.getCognome());
        } else if (StringUtils.hasLength(params.getNome())) {
            listFindMedico = medicoRepository.findByNome(params.getNome());
        } else if (StringUtils.hasLength(params.getCognome())) {
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
            if(StringUtils.hasLength(params.getNuovoNome())){
                modifyMedico.setNome(params.getNuovoNome());
            }
            if(StringUtils.hasLength(params.getNuovoCognome())){
                modifyMedico.setCognome(params.getNuovoCognome());
            }
            if(StringUtils.hasLength(params.getNuovoTurno())){
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
