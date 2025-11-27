package Desafio_Preco_Justo;
import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mockito;

import Desafio_Preco_Justo.Service.PatoService;
import Desafio_Preco_Justo.Repository.PatoRepository;
import Desafio_Preco_Justo.DTO.PatoDTO;
import Desafio_Preco_Justo.Model.Pato;
import Desafio_Preco_Justo.Model.StatusPato;

    
public class PatoTest {
    
  
    
        @Test
        void cadastrarPato() {
    
           
            PatoRepository patoRepository = Mockito.mock(PatoRepository.class);
            PatoService patoService = new PatoService(patoRepository);
    
           
            PatoDTO patoDTO = new PatoDTO("Pato Teste", null);
    
            
            Pato patoSalvo = new Pato();
            patoSalvo.setId(1L);
            patoSalvo.setNome("Pato Teste");
            patoSalvo.setPreco(70.0);
            patoSalvo.setStatusvenda(StatusPato.disponivel);
    
           
            Mockito.when(patoRepository.countByMae(Mockito.any(Pato.class)))
                    .thenReturn(0);
    
            Mockito.when(patoRepository.save(Mockito.any(Pato.class)))
                    .thenReturn(patoSalvo);
    
           
            Pato patoCadastrado = patoService.cadastrarPato(patoDTO);
    
            
            Assertions.assertNotNull(patoCadastrado);
            Assertions.assertEquals(1L, patoCadastrado.getId());
            Assertions.assertEquals("Pato Teste", patoCadastrado.getNome());
            Assertions.assertEquals(70.0, patoCadastrado.getPreco());
            Assertions.assertEquals(StatusPato.disponivel, patoCadastrado.getStatusvenda());
    
           
            Mockito.verify(patoRepository, Mockito.times(1)).countByMae(Mockito.any(Pato.class));
            Mockito.verify(patoRepository, Mockito.times(1)).save(Mockito.any(Pato.class));
        }
    }
    



