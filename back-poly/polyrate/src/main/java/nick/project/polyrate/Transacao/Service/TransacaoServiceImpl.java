package nick.project.polyrate.Transacao.Service;

import nick.project.polyrate.Transacao.Mapper.TransacaoMapper;
import nick.project.polyrate.Transacao.Objects.dto.TransacaoDTO;
import nick.project.polyrate.Transacao.Repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private TransacaoMapper transacaoMapper;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
    }

    @Override
    public Page<TransacaoDTO> listarExtrato(Pageable pageable) {
        return transacaoRepository.findAll(pageable).map(transacaoMapper::toResponse);
    }

    @Override
    public TransacaoDTO buscarPorId(BigInteger id) {
        return transacaoRepository.findById(id)
                .map(transacaoMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }
}
