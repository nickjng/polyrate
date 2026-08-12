package nick.project.polyrate.Recebivel.Service;

import nick.project.polyrate.Recebivel.Objects.dao.RecebivelDAO;
import nick.project.polyrate.Recebivel.Objects.dto.RecebivelDTO;

import java.math.BigInteger;
import java.util.List;

public interface RecebivelService {

    List<RecebivelDTO> listarRecebiveis();
    RecebivelDTO buscarPorId(BigInteger id);
    RecebivelDTO cadastrarRecebivel(RecebivelDAO recebivelBody);

    // Propositalmente NÃO tem simular()/liquidar() aqui ainda.
    // É onde entra o Strategy Pattern (EstrategiaPrecificacao) + a lógica
    // de conversão cross-currency. Essa é a parte que fica com você.
}
