package Desafio_Preco_Justo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Desafio_Preco_Justo.Service.VendedorService;

import java.util.List;

import org.apache.commons.collections4.Get;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import Desafio_Preco_Justo.Model.Vendedor;
import Desafio_Preco_Justo.DTO.VendedorDTO;
import Desafio_Preco_Justo.DTO.VendedorRankingDTO;
@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    
    private final VendedorService vendedorService;
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }
    @PostMapping("/cadastrarVendedor")
    public ResponseEntity<Vendedor> cadastrarVendedor(@RequestBody VendedorDTO dto) {
        Vendedor vendedorCadastrado = vendedorService.cadastrarVendedor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedorCadastrado);
    }
    @GetMapping("/ranking")
    public ResponseEntity<List<VendedorRankingDTO>> obterRankingVendedores() {
        List<VendedorRankingDTO> ranking = vendedorService.ranking();
        return ResponseEntity.ok(ranking);
    }
}
