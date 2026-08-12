package nick.project.polyrate.Transacao.Controller;

import nick.project.polyrate.Transacao.Objects.dto.TransacaoDTO;
import nick.project.polyrate.Transacao.Service.TransacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoServiceImpl transacaoService;

    public TransacaoController(TransacaoServiceImpl transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<TransacaoDTO>> listarExtrato(Pageable pageable) {
        return ResponseEntity.status(200).body(transacaoService.listarExtrato(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDTO> buscarPorId(@PathVariable BigInteger id) {
        return ResponseEntity.status(200).body(transacaoService.buscarPorId(id));
    }
}
