package nick.project.polyrate.TipoRecebivel.Objects.dao;

import nick.project.polyrate.TipoRecebivel.Objects.enums.CodigoEstrategia;

import java.math.BigDecimal;

public record TipoRecebivelDAO(
        String nome,
        CodigoEstrategia codigoEstrategia,
        BigDecimal spreadPercentual
) {
}
