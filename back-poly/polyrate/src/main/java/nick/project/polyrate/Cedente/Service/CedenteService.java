package nick.project.polyrate.Cedente.Service;

import nick.project.polyrate.Cedente.Objects.dao.CedenteDAO;
import nick.project.polyrate.Cedente.Objects.dto.CedenteDTO;

import java.util.List;

public interface CedenteService {

    List<CedenteDTO> listarCedentes();
    CedenteDTO cadastrarCedente(CedenteDAO cedenteBody);
}
