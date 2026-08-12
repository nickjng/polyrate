package nick.project.polyrate.Moeda.Service;

import nick.project.polyrate.Moeda.Objects.dao.MoedaDAO;
import nick.project.polyrate.Moeda.Objects.dto.MoedaDTO;

import java.util.List;

public interface MoedaService {

    List<MoedaDTO> listarMoedas();
    MoedaDTO cadastrarMoeda(MoedaDAO moedaBody);

}
