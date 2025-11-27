package Desafio_Preco_Justo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Desafio_Preco_Justo.DTO.ClienteDTO;
import Desafio_Preco_Justo.Model.Cliente;
import Desafio_Preco_Justo.Repository.ClienteRepository;
import Desafio_Preco_Justo.Service.ClienteService;

public class ClienteTest {
    

    @Test
    public void cadastroCliente() {
        
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(clienteRepository);
        ClienteDTO clienteDTO = new ClienteDTO("Cliente Teste", true);
        Cliente clienteSalvo = new Cliente();
        clienteSalvo.setId(1L);
        clienteSalvo.setNome("Cliente Teste");
        clienteSalvo.setElegivelDesconto(true);
        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class)))
                .thenReturn(clienteSalvo);
        Cliente clienteCadastrado = clienteService.cadastrarCliente(clienteDTO);
        Mockito.verify(clienteRepository, Mockito.times(1)).save(Mockito.any(Cliente.class));
        

    }
}
