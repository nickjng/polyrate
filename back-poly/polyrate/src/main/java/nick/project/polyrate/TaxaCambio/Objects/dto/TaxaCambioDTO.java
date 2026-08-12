package nick.project.polyrate.TaxaCambio.Objects.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
public class TaxaCambioDTO {

    private Integer idTaxaCambio;
    private String codigoMoedaOrigem;
    private String codigoMoedaDestino;
    private BigDecimal taxa;
    private LocalDate dataReferencia;

    public TaxaCambioDTO(Integer idTaxaCambio, String codigoMoedaOrigem, String codigoMoedaDestino,
                          BigDecimal taxa, LocalDate dataReferencia) {
        this.idTaxaCambio = idTaxaCambio;
        this.codigoMoedaOrigem = codigoMoedaOrigem;
        this.codigoMoedaDestino = codigoMoedaDestino;
        this.taxa = taxa;
        this.dataReferencia = dataReferencia;
    }
}
