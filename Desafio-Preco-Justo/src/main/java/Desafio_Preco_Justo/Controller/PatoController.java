package Desafio_Preco_Justo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import Desafio_Preco_Justo.Model.Pato;
import Desafio_Preco_Justo.DTO.PatoDTO;
import Desafio_Preco_Justo.Service.PatoService;
@RestController //indica que a classe é um controlador do Spring
@RequestMapping("/patos") //mapeia as requisições para o endpoint /patos
public class PatoController {
    
    private final PatoService patoService;
    public PatoController(PatoService patoService) {
        this.patoService = patoService;
    }

    @PostMapping("/cadastrarPato")
    public ResponseEntity<Pato> cadastrarPato(@RequestBody PatoDTO dto) {// RespnseEntity para controle do status da resposta
        Pato patoCadastrado = patoService.cadastrarPato(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patoCadastrado);
    }
    
}
