package nick.project.polyrate.Moeda.Service;


import nick.project.polyrate.Moeda.Entity.MoedaEntity;
import nick.project.polyrate.Moeda.Mapper.MoedaMapper;
import nick.project.polyrate.Moeda.Objects.dao.MoedaDAO;
import nick.project.polyrate.Moeda.Objects.dto.MoedaDTO;
import nick.project.polyrate.Moeda.Repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoedaServiceImpl implements MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    @Autowired
    private MoedaMapper moedaMapper;

    public MoedaServiceImpl(MoedaRepository moedaRepository, MoedaMapper moedaMapper) {
        this.moedaRepository = moedaRepository;
        this.moedaMapper = moedaMapper;
    }

    @Override
    public List<MoedaDTO> listarMoedas() {
        List<MoedaEntity> moedas = moedaRepository.findAll();
        return moedas.stream()
                .map(moedaMapper::toResponse)
                .toList();
    }

    @Override
    public MoedaDTO cadastrarMoeda(MoedaDAO moedaBody) {
        MoedaEntity novaMoeda = moedaMapper.toEntity(moedaBody);
        return moedaMapper.toResponse(moedaRepository.save(novaMoeda));
    }
}
