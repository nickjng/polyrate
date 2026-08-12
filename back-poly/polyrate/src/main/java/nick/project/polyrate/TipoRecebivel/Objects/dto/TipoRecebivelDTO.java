package nick.project.polyrate.TipoRecebivel.Objects.dto;

import lombok.Getter;
import nick.project.polyrate.TipoRecebivel.Objects.enums.CodigoEstrategia;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
public class TipoRecebivelDTO {

    private BigInteger idTipoRecebivel;
    private String nomeTipoRecebivel;
    private CodigoEstrategia codigoEstrategia;
    private BigDecimal spreadPercentual;

    public TipoRecebivelDTO(BigInteger idTipoRecebivel, String nomeTipoRecebivel,
                             CodigoEstrategia codigoEstrategia, BigDecimal spreadPercentual) {
        this.idTipoRecebivel = idTipoRecebivel;
        this.nomeTipoRecebivel = nomeTipoRecebivel;
        this.codigoEstrategia = codigoEstrategia;
        this.spreadPercentual = spreadPercentual;
    }
}
