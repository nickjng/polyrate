package nick.project.polyrate.Cedente.Controller;

import nick.project.polyrate.Cedente.Objects.dao.CedenteDAO;
import nick.project.polyrate.Cedente.Objects.dto.CedenteDTO;
import nick.project.polyrate.Cedente.Service.CedenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
