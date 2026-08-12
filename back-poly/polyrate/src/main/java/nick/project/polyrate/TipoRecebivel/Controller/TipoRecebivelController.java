package nick.project.polyrate.TipoRecebivel.Controller;

import nick.project.polyrate.TipoRecebivel.Objects.dao.TipoRecebivelDAO;
import nick.project.polyrate.TipoRecebivel.Objects.dto.TipoRecebivelDTO;
import nick.project.polyrate.TipoRecebivel.Service.TipoRecebivelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-recebivel")
public class TipoRecebivelController {

    @Autowired
    private TipoRecebivelServiceImpl tipoRecebivelService;

    public TipoRecebivelController(TipoRecebivelServiceImpl tipoRecebivelService) {
        this.tipoRecebivelService = tipoRecebivelService;
    }

    @GetMapping
    public ResponseEntity<List<TipoRecebivelDTO>> listarTipos() {
        return ResponseEntity.status(200).body(tipoRecebivelService.listarTipos());
    }

    @PostMapping
    public ResponseEntity<TipoRecebivelDTO> cadastrarTipo(@RequestBody TipoRecebivelDAO tipoBody) {
        return ResponseEntity.status(201).body(tipoRecebivelService.cadastrarTipo(tipoBody));
    }
}
