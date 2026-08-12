package nick.project.polyrate.Transacao.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nick.project.polyrate.Moeda.Entity.MoedaEntity;
import nick.project.polyrate.Recebivel.Entity.RecebivelEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transacao")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private Integer idTransacao;

    @ManyToOne
    @JoinColumn(name = "id_recebivel", nullable = false)
    private RecebivelEntity recebivel;

    @Column(name = "taxa_base_aplicada", precision = 9, scale = 6, nullable = false)
    private BigDecimal taxaBaseAplicada;

    @Column(name = "spread_aplicado", precision = 9, scale = 6, nullable = false)
    private BigDecimal spreadAplicado;

    @Column(name = "taxa_cambio_aplicada", precision = 18, scale = 8)
    private BigDecimal taxaCambioAplicada;

    @ManyToOne
    @JoinColumn(name = "moeda_pagamento_id", nullable = false)
    private MoedaEntity moedaPagamento;

    @Column(name = "valor_presente_calculado", precision = 18, scale = 2, nullable = false)
    private BigDecimal valorPresenteCalculado;

    @Column(name = "valor_liquido_final", precision = 18, scale = 2, nullable = false)
    private BigDecimal valorLiquidoFinal;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}