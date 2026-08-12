package nick.project.polyrate.TaxaCambio.Objects.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public record TaxaCambioDAO(
        Integer moedaOrigemId,
        Integer moedaDestinoId,
        BigDecimal taxa,
        LocalDate dataReferencia
) {
}
