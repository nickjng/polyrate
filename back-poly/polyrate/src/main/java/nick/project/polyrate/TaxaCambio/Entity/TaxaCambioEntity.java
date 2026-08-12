package nick.project.polyrate.TaxaCambio.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nick.project.polyrate.Moeda.Entity.MoedaEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "taxa_cambio")
public class TaxaCambioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_taxa_cambio")
    private Integer idTaxaCambio;

    @ManyToOne
    @JoinColumn(name = "moeda_origem_id", nullable = false)
    private MoedaEntity moedaOrigem;

    @ManyToOne
    @JoinColumn(name = "moeda_destino_id", nullable = false)
    private MoedaEntity moedaDestino;

    @Column(name = "taxa", precision = 18, scale = 8, nullable = false)
    private BigDecimal taxa;

    @Column(name = "data_referencia", nullable = false)
    private LocalDate dataReferencia;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}