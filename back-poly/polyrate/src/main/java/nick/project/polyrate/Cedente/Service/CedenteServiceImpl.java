package nick.project.polyrate.Cedente.Service;

import nick.project.polyrate.Cedente.Entity.CedenteEntity;
import nick.project.polyrate.Cedente.Mapper.CedenteMapper;
import nick.project.polyrate.Cedente.Objects.dao.CedenteDAO;
import nick.project.polyrate.Cedente.Objects.dto.CedenteDTO;
import nick.project.polyrate.Cedente.Repository.CedenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CedenteServiceImpl implements CedenteService {

    @Autowired
    private CedenteRepository cedenteRepository;

    @Autowired
    private CedenteMapper cedenteMapper;

    public CedenteServiceImpl(CedenteRepository cedenteRepository, CedenteMapper cedenteMapper) {
        this.cedenteRepository = cedenteRepository;
        this.cedenteMapper = cedenteMapper;
    }

    @Override
    public List<CedenteDTO> listarCedentes() {
        return cedenteRepository.findAll().stream()
                .map(cedenteMapper::toResponse)
                .toList();
    }

    @Override
    public CedenteDTO cadastrarCedente(CedenteDAO cedenteBody) {
        CedenteEntity novoCedente = cedenteMapper.toEntity(cedenteBody);
        return cedenteMapper.toResponse(cedenteRepository.save(novoCedente));
    }
}
