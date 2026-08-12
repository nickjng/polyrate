package nick.project.polyrate.TaxaCambio.Controller;

import nick.project.polyrate.TaxaCambio.Objects.dao.TaxaCambioDAO;
import nick.project.polyrate.TaxaCambio.Objects.dto.TaxaCambioDTO;
import nick.project.polyrate.TaxaCambio.Service.TaxaCambioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/taxa-cambio")
public class TaxaCambioController {

    @Autowired
    private TaxaCambioServiceImpl taxaCambioService;

    public TaxaCambioController(TaxaCambioServiceImpl taxaCambioService) {
        this.taxaCambioService = taxaCambioService;
    }

    @GetMapping
    public ResponseEntity<List<TaxaCambioDTO>> listarTaxas() {
        return ResponseEntity.status(200).body(taxaCambioService.listarTaxas());
    }

    @PostMapping
    public ResponseEntity<TaxaCambioDTO> cadastrarTaxa(@RequestBody TaxaCambioDAO taxaCambioBody) {
        return ResponseEntity.status(201).body(taxaCambioService.cadastrarTaxa(taxaCambioBody));
    }

    @GetMapping("/vigente")
    public ResponseEntity<TaxaCambioDTO> buscarTaxaVigente(
            @RequestParam BigInteger moedaOrigemId,
            @RequestParam BigInteger moedaDestinoId) {
        return ResponseEntity.status(200).body(taxaCambioService.buscarTaxaVigente(moedaOrigemId, moedaDestinoId));
    }
}
