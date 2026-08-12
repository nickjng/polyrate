package nick.project.polyrate.Recebivel.Objects.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public record RecebivelDAO(
        Integer cedenteId,
        Integer tipoRecebivelId,
        BigDecimal valorFace,
        Integer moedaTituloId,
        LocalDate dataVencimento
) {
}
