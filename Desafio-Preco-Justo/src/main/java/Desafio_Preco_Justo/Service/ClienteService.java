package Desafio_Preco_Justo.Service;

import org.springframework.stereotype.Service;
import Desafio_Preco_Justo.Repository.ClienteRepository;
import Desafio_Preco_Justo.Model.Cliente;
import Desafio_Preco_Justo.DTO.ClienteDTO;
@Service //Indica que a classe é lógica do negócio do Spring
public class ClienteService {
    

    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public Cliente cadastrarCliente(ClienteDTO clientedto) {
        Cliente cliente = new Cliente();
        cliente.setNome(clientedto.getNome());
        cliente.setElegivelDesconto(clientedto.getElegivelDesconto());
        
        return clienteRepository.save(cliente);
    }
}
