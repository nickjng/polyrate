package nick.project.polyrate.Transacao.Service;

import nick.project.polyrate.Transacao.Objects.dto.TransacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface TransacaoService {

    Page<TransacaoDTO> listarExtrato(Pageable pageable);
    TransacaoDTO buscarPorId(Integer id);

}
