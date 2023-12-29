package com.bff.service.msinfo;

import com.bff.dto.msinfo.MedicoDto;
import com.bff.dto.msinfo.params.medico.AddMedicoParams;
import com.bff.dto.msinfo.params.medico.FindMedicoParams;
import com.bff.dto.msinfo.params.medico.ModifyMedicoParams;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    public List<MedicoDto> findAll() {
        return null;
    }

    public List<MedicoDto> findMedico(FindMedicoParams params) {
        return null;
    }

    public String deleteMedico(Integer id) {
        return null;
    }

    public MedicoDto modifyMedico(ModifyMedicoParams params) {
        return null;
    }

    public MedicoDto addMedico(AddMedicoParams params) {
        return null;
    }
}
