package nick.project.polyrate.Recebivel.Objects.dto;

import lombok.Getter;
import nick.project.polyrate.Recebivel.Objects.enums.StatusRecebivel;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
public class RecebivelDTO {

    private Integer idRecebivel;
    private String nomeCedente;
    private String nomeTipoRecebivel;
    private Integer valorFace;
    private String codigoMoedaTitulo;
    private LocalDate dataVencimento;
    private LocalDate dataOperacao;
    private StatusRecebivel status;

    public RecebivelDTO(Integer idRecebivel, String nomeCedente, String nomeTipoRecebivel, Integer valorFace, String codigoMoedaTitulo, LocalDate dataVencimento, LocalDate dataOperacao, StatusRecebivel status) {
        this.idRecebivel = idRecebivel;
        this.nomeCedente = nomeCedente;
        this.nomeTipoRecebivel = nomeTipoRecebivel;
        this.valorFace = valorFace;
        this.codigoMoedaTitulo = codigoMoedaTitulo;
        this.dataVencimento = dataVencimento;
        this.dataOperacao = dataOperacao;
        this.status = status;
    }
}
