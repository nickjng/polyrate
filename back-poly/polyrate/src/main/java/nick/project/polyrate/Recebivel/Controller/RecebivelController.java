package nick.project.polyrate.Recebivel.Controller;

import nick.project.polyrate.Recebivel.Objects.dao.RecebivelDAO;
import nick.project.polyrate.Recebivel.Objects.dto.RecebivelDTO;
import nick.project.polyrate.Recebivel.Service.RecebivelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/recebivel")
public class RecebivelController {

    @Autowired
    private RecebivelServiceImpl recebivelService;

    public RecebivelController(RecebivelServiceImpl recebivelService) {
        this.recebivelService = recebivelService;
    }

    @GetMapping
    public ResponseEntity<List<RecebivelDTO>> listarRecebiveis() {
        return ResponseEntity.status(200).body(recebivelService.listarRecebiveis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecebivelDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(recebivelService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RecebivelDTO> cadastrarRecebivel(@RequestBody RecebivelDAO recebivelBody) {
        return ResponseEntity.status(201).body(recebivelService.cadastrarRecebivel(recebivelBody));
    }

    // TODO (você): @PostMapping("/{id}/simular") e @PostMapping("/{id}/liquidar")
    // entram aqui depois que a EstrategiaPrecificacao existir.
}
