package nick.project.polyrate.Cedente.Objects.dto;

import lombok.Getter;

@Getter
public class CedenteDTO {

    private Integer idCedente;
    private String nomeCedente;
    private String documentoCedente;

    public CedenteDTO(Integer idCedente, String nomeCedente, String documentoCedente) {
        this.idCedente = idCedente;
        this.nomeCedente = nomeCedente;
        this.documentoCedente = documentoCedente;
    }
}

