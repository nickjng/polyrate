package nick.project.polyrate.Transacao.Objects.dto;

import lombok.Getter;
import nick.project.polyrate.Transacao.Objects.enums.StatusTransacao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
public class TransacaoDTO {

    private BigInteger idTransacao;
    private BigInteger idRecebivel;
    private BigDecimal taxaBaseAplicada;
    private BigDecimal spreadAplicado;
    private BigDecimal taxaCambioAplicada;
    private String codigoMoedaPagamento;
    private BigDecimal valorPresenteCalculado;
    private BigDecimal valorLiquidoFinal;
    private StatusTransacao status;
    private LocalDateTime createdAt;

    public TransacaoDTO(BigInteger idTransacao, BigInteger idRecebivel, BigDecimal taxaBaseAplicada,
                         BigDecimal spreadAplicado, BigDecimal taxaCambioAplicada, String codigoMoedaPagamento,
                         BigDecimal valorPresenteCalculado, BigDecimal valorLiquidoFinal,
                         StatusTransacao status, LocalDateTime createdAt) {
        this.idTransacao = idTransacao;
        this.idRecebivel = idRecebivel;
        this.taxaBaseAplicada = taxaBaseAplicada;
        this.spreadAplicado = spreadAplicado;
        this.taxaCambioAplicada = taxaCambioAplicada;
        this.codigoMoedaPagamento = codigoMoedaPagamento;
        this.valorPresenteCalculado = valorPresenteCalculado;
        this.valorLiquidoFinal = valorLiquidoFinal;
        this.status = status;
        this.createdAt = createdAt;
    }
}
