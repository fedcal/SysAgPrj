package com.msinfo.dto.params.reparto;

import com.msinfo.dto.MedicoDto;
import lombok.Data;

@Data
public class AddRepartoParams {
    private String nomeReparto;
    private String descrizione;
    private String alaReparto;
    private Integer capoReparto;
}
