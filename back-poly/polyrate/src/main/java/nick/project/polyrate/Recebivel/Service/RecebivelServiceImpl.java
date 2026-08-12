package nick.project.polyrate.Recebivel.Service;

import nick.project.polyrate.Cedente.Entity.CedenteEntity;
import nick.project.polyrate.Cedente.Repository.CedenteRepository;
import nick.project.polyrate.Moeda.Entity.MoedaEntity;
import nick.project.polyrate.Moeda.Repository.MoedaRepository;
import nick.project.polyrate.Recebivel.Entity.RecebivelEntity;
import nick.project.polyrate.Recebivel.Mapper.RecebivelMapper;
import nick.project.polyrate.Recebivel.Objects.dao.RecebivelDAO;
import nick.project.polyrate.Recebivel.Objects.dto.RecebivelDTO;
import nick.project.polyrate.Recebivel.Repository.RecebivelRepository;
import nick.project.polyrate.TipoRecebivel.Entity.TipoRecebivelEntity;
import nick.project.polyrate.TipoRecebivel.Repository.TipoRecebivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RecebivelServiceImpl implements RecebivelService {

    @Autowired
    private RecebivelRepository recebivelRepository;

    @Autowired
    private CedenteRepository cedenteRepository;

    @Autowired
    private TipoRecebivelRepository tipoRecebivelRepository;

    @Autowired
    private MoedaRepository moedaRepository;

    @Autowired
    private RecebivelMapper recebivelMapper;

    public RecebivelServiceImpl(RecebivelRepository recebivelRepository, CedenteRepository cedenteRepository,
                                 TipoRecebivelRepository tipoRecebivelRepository, MoedaRepository moedaRepository,
                                 RecebivelMapper recebivelMapper) {
        this.recebivelRepository = recebivelRepository;
        this.cedenteRepository = cedenteRepository;
        this.tipoRecebivelRepository = tipoRecebivelRepository;
        this.moedaRepository = moedaRepository;
        this.recebivelMapper = recebivelMapper;
    }

    @Override
    public List<RecebivelDTO> listarRecebiveis() {
        return recebivelRepository.findAll().stream()
                .map(recebivelMapper::toResponse)
                .toList();
    }

    @Override
    public RecebivelDTO buscarPorId(BigInteger id) {
        return recebivelRepository.findById(id)
                .map(recebivelMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Recebível não encontrado"));
    }

    @Override
    public RecebivelDTO cadastrarRecebivel(RecebivelDAO recebivelBody) {
        // TODO: validar que dataVencimento >= hoje, e tratar NotFound de forma
        // adequada (exception própria + @ControllerAdvice), não RuntimeException crua.
        CedenteEntity cedente = cedenteRepository.findById(recebivelBody.cedenteId())
                .orElseThrow(() -> new RuntimeException("Cedente não encontrado"));
        TipoRecebivelEntity tipo = tipoRecebivelRepository.findById(recebivelBody.tipoRecebivelId())
                .orElseThrow(() -> new RuntimeException("Tipo de recebível não encontrado"));
        MoedaEntity moeda = moedaRepository.findById(recebivelBody.moedaTituloId())
                .orElseThrow(() -> new RuntimeException("Moeda não encontrada"));

        RecebivelEntity novoRecebivel = new RecebivelEntity();
        novoRecebivel.setCedente(cedente);
        novoRecebivel.setTipoRecebivel(tipo);
        novoRecebivel.setValorFace(recebivelBody.valorFace());
        novoRecebivel.setMoedaTitulo(moeda);
        novoRecebivel.setDataVencimento(recebivelBody.dataVencimento());
        // status já nasce PENDENTE por default na entidade

        return recebivelMapper.toResponse(recebivelRepository.save(novoRecebivel));
    }
}
