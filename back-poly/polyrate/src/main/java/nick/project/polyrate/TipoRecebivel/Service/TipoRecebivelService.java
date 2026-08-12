package nick.project.polyrate.TipoRecebivel.Service;

import nick.project.polyrate.TipoRecebivel.Objects.dao.TipoRecebivelDAO;
import nick.project.polyrate.TipoRecebivel.Objects.dto.TipoRecebivelDTO;

import java.util.List;

public interface TipoRecebivelService {

    List<TipoRecebivelDTO> listarTipos();
    TipoRecebivelDTO cadastrarTipo(TipoRecebivelDAO tipoBody);
}
