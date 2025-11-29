package Desafio_Preco_Justo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Desafio_Preco_Justo.DTO.VendedorDTO;
import Desafio_Preco_Justo.Repository.VendedorRepository;
import Desafio_Preco_Justo.Service.VendedorService;

public class VendedorTest {
    
    @Test
    public void cadastroVendedor() {
        VendedorRepository vendedorRepository = Mockito.mock(VendedorRepository.class);
        VendedorService vendedorService = new VendedorService(vendedorRepository);
        VendedorDTO vendedorDTO = new VendedorDTO("Vendedor Teste", "12345678901", "MAT12345");
        Mockito.when(vendedorRepository.existsByCpf(Mockito.anyString())).thenReturn(false);
        Mockito.when(vendedorRepository.existsByMatricula(Mockito.anyString())).thenReturn(false);
        Mockito.when(vendedorRepository.save(Mockito.any())).thenAnswer(i -> i.getArgument(0));
        vendedorService.cadastrarVendedor(vendedorDTO);
        Mockito.verify(vendedorRepository, Mockito.times(1)).existsByCpf("12345678901");
        Mockito.verify(vendedorRepository, Mockito.times(1)).existsByMatricula("MAT12345");
        Mockito.verify(vendedorRepository, Mockito.times(1)).save(Mockito.any());

    }
}
