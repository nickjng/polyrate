package nick.project.polyrate.Cedente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cedente")
public class CedenteController {

    @Autowired
    private CedenteServiceImpl cedenteService;

    public CedenteController(CedenteServiceImpl cedenteService) {
        this.cedenteService = cedenteService;
    }

    @GetMapping
    public ResponseEntity<List<CedenteDTO>> listarCedentes() {
        return ResponseEntity.status(200).body(cedenteService.listarCedentes());
    }

    @PostMapping
    public ResponseEntity<CedenteDTO> cadastrarCedente(@RequestBody CedenteDAO cedenteBody) {
        return ResponseEntity.status(201).body(cedenteService.cadastrarCedente(cedenteBody));
    }
}
