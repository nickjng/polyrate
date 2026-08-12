package nick.project.polyrate.TaxaCambio.Service;

import nick.project.polyrate.TaxaCambio.Objects.dao.TaxaCambioDAO;
import nick.project.polyrate.TaxaCambio.Objects.dto.TaxaCambioDTO;

import java.math.BigInteger;
import java.util.List;

public interface TaxaCambioService {

    List<TaxaCambioDTO> listarTaxas();
    TaxaCambioDTO cadastrarTaxa(TaxaCambioDAO taxaCambioBody);
    TaxaCambioDTO buscarTaxaVigente(Integer moedaOrigemId, Integer moedaDestinoId);
}
