package nick.project.polyrate.TaxaCambio.Service;

import nick.project.polyrate.Moeda.Entity.MoedaEntity;
import nick.project.polyrate.Moeda.Repository.MoedaRepository;
import nick.project.polyrate.TaxaCambio.Entity.TaxaCambioEntity;
import nick.project.polyrate.TaxaCambio.Mapper.TaxaCambioMapper;
import nick.project.polyrate.TaxaCambio.Objects.dao.TaxaCambioDAO;
import nick.project.polyrate.TaxaCambio.Objects.dto.TaxaCambioDTO;
import nick.project.polyrate.TaxaCambio.Repository.TaxaCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TaxaCambioServiceImpl implements TaxaCambioService {

    @Autowired
    private TaxaCambioRepository taxaCambioRepository;

    @Autowired
    private MoedaRepository moedaRepository;

    @Autowired
    private TaxaCambioMapper taxaCambioMapper;

    public TaxaCambioServiceImpl(TaxaCambioRepository taxaCambioRepository, MoedaRepository moedaRepository,
                                  TaxaCambioMapper taxaCambioMapper) {
        this.taxaCambioRepository = taxaCambioRepository;
        this.moedaRepository = moedaRepository;
        this.taxaCambioMapper = taxaCambioMapper;
    }

    @Override
    public List<TaxaCambioDTO> listarTaxas() {
        return taxaCambioRepository.findAll().stream()
                .map(taxaCambioMapper::toResponse)
                .toList();
    }

    @Override
    public TaxaCambioDTO cadastrarTaxa(TaxaCambioDAO taxaCambioBody) {
        // TODO: trocar RuntimeException por uma exception de negócio própria
        // (ex: RecursoNaoEncontradoException) tratada no @ControllerAdvice.
        MoedaEntity origem = moedaRepository.findById(taxaCambioBody.moedaOrigemId())
                .orElseThrow(() -> new RuntimeException("Moeda origem não encontrada"));
        MoedaEntity destino = moedaRepository.findById(taxaCambioBody.moedaDestinoId())
                .orElseThrow(() -> new RuntimeException("Moeda destino não encontrada"));

        TaxaCambioEntity novaTaxa = new TaxaCambioEntity();
        novaTaxa.setMoedaOrigem(origem);
        novaTaxa.setMoedaDestino(destino);
        novaTaxa.setTaxa(taxaCambioBody.taxa());
        novaTaxa.setDataReferencia(taxaCambioBody.dataReferencia());

        return taxaCambioMapper.toResponse(taxaCambioRepository.save(novaTaxa));
    }

    @Override
    public TaxaCambioDTO buscarTaxaVigente(BigInteger moedaOrigemId, BigInteger moedaDestinoId) {
        return taxaCambioRepository
                .findTopByMoedaOrigem_IdAndMoedaDestino_IdOrderByDataReferenciaDesc(moedaOrigemId, moedaDestinoId)
                .map(taxaCambioMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Taxa de câmbio não cadastrada para esse par"));
    }
}
