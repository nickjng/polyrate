package nick.project.polyrate.Moeda.Objects.dto;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class MoedaDTO {

    private BigInteger idMoeda;
    private String codigoMoeda;
    private String nomeMoeda;


    public MoedaDTO(BigInteger idMoeda, String codigoMoeda, String nomeMoeda) {
        this.idMoeda = idMoeda;
        this.codigoMoeda = codigoMoeda;
        this.nomeMoeda = nomeMoeda;
    }
}
