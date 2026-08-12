package nick.project.polyrate.Recebivel.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nick.project.polyrate.Cedente.Entity.CedenteEntity;
import nick.project.polyrate.Moeda.Entity.MoedaEntity;
import nick.project.polyrate.TipoRecebivel.Entity.TipoRecebivelEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "recebivel")
public class RecebivelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recebivel")
    private Integer idRecebivel;

    @ManyToOne
    @JoinColumn(name = "cedente_id", nullable = false)
    private CedenteEntity cedente;

    @ManyToOne
    @JoinColumn(name = "tipo_recebivel_id", nullable = false)
    private TipoRecebivelEntity tipoRecebivel;

    @Column(name = "valor_face", precision = 18, scale = 2, nullable = false)
    private BigDecimal valorFace;

    @ManyToOne
    @JoinColumn(name = "moeda_titulo_id", nullable = false)
    private MoedaEntity moedaTitulo;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "data_operacao", nullable = false)
    private LocalDate dataOperacao;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}