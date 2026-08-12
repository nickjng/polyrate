package nick.project.polyrate.Moeda.Controller;

import nick.project.polyrate.Moeda.Objects.dao.MoedaDAO;
import nick.project.polyrate.Moeda.Objects.dto.MoedaDTO;
import nick.project.polyrate.Moeda.Service.MoedaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moeda")
public class MoedaController {

    @Autowired
    private MoedaServiceImpl moedaService;

    public MoedaController(MoedaServiceImpl moedaService) {
        this.moedaService = moedaService;
    }

    @GetMapping
    public ResponseEntity<List<MoedaDTO>> listarMoedas(){
        return ResponseEntity.status(200).body(moedaService.listarMoedas());
    }

    @PostMapping
    public ResponseEntity<MoedaDTO> cadastrarMoeda(@RequestBody MoedaDAO moedaBody){
        return ResponseEntity.status(202).body(moedaService.cadastrarMoeda(moedaBody));
    }


}
