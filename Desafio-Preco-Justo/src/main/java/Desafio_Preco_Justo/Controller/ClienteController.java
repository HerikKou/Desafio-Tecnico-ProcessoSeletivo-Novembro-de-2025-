package Desafio_Preco_Justo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import Desafio_Preco_Justo.Model.Cliente;
import Desafio_Preco_Justo.DTO.ClienteDTO;
import Desafio_Preco_Justo.Service.ClienteService;
@RestController
@RequestMapping("/clientes")
public class ClienteController {
        private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @PostMapping("/cadastrarCliente")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteDTO dto) {
        Cliente clienteCadastrado = clienteService.cadastrarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
    }
}
