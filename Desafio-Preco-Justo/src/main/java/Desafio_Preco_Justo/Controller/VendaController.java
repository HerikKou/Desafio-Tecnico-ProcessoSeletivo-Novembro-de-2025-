package Desafio_Preco_Justo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Desafio_Preco_Justo.DTO.VendaDTO;
import Desafio_Preco_Justo.Model.Vendas;
import Desafio_Preco_Justo.Service.VendaService;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/vendas")
public class VendaController {
    

    private final VendaService vendasService;
    public VendaController(VendaService vendasService) {
        this.vendasService = vendasService;
    }
    @PostMapping("/registrarVenda")
    public ResponseEntity<Vendas> registrarVenda(@RequestBody VendaDTO vendadto) {
        Vendas vendaRegistrada = vendasService.registrarVenda(vendadto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaRegistrada);
    }

    @GetMapping("/obterVendas")
    public ResponseEntity<List<Vendas>> obterVendas(){
        List<Vendas> totalVendas = vendasService.obterTodasVendas();
        return ResponseEntity.status(HttpStatus.OK).body(totalVendas);
    }
    
    @GetMapping("/relatorio")
public ResponseEntity<byte[]> gerarRelatorio() {
    try {
        ByteArrayInputStream in = vendasService.gerarRelatorio();
        byte[] bytes = in.readAllBytes();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=relatorio_vendas.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(bytes);

    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
}
