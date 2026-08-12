package nick.project.polyrate.TipoRecebivel.Service;

import nick.project.polyrate.TipoRecebivel.Entity.TipoRecebivelEntity;
import nick.project.polyrate.TipoRecebivel.Mapper.TipoRecebivelMapper;
import nick.project.polyrate.TipoRecebivel.Objects.dao.TipoRecebivelDAO;
import nick.project.polyrate.TipoRecebivel.Objects.dto.TipoRecebivelDTO;
import nick.project.polyrate.TipoRecebivel.Repository.TipoRecebivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoRecebivelServiceImpl implements TipoRecebivelService {

    @Autowired
    private TipoRecebivelRepository tipoRecebivelRepository;

    @Autowired
    private TipoRecebivelMapper tipoRecebivelMapper;

    public TipoRecebivelServiceImpl(TipoRecebivelRepository tipoRecebivelRepository,
                                     TipoRecebivelMapper tipoRecebivelMapper) {
        this.tipoRecebivelRepository = tipoRecebivelRepository;
        this.tipoRecebivelMapper = tipoRecebivelMapper;
    }

    @Override
    public List<TipoRecebivelDTO> listarTipos() {
        return tipoRecebivelRepository.findAll().stream()
                .map(tipoRecebivelMapper::toResponse)
                .toList();
    }

    @Override
    public TipoRecebivelDTO cadastrarTipo(TipoRecebivelDAO tipoBody) {
        TipoRecebivelEntity novoTipo = tipoRecebivelMapper.toEntity(tipoBody);
        return tipoRecebivelMapper.toResponse(tipoRecebivelRepository.save(novoTipo));
    }
}
