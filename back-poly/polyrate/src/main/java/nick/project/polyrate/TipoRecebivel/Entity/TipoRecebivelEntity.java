package nick.project.polyrate.TipoRecebivel.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tipo_recebivel")
public class TipoRecebivelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "codigo_estrategia", length = 50, nullable = false, unique = true)
    private String codigoEstrategia;

    @Column(name = "spread_percentual", precision = 7, scale = 4, nullable = false)
    private BigDecimal spreadPercentual;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}