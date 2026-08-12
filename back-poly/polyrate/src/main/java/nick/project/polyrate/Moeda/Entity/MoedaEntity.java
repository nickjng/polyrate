package nick.project.polyrate.Moeda.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "moeda")
public class MoedaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moeda")
    private Integer idMoeda;

    @Column
    private String codigo;

    @Column
    private String nome;

}
