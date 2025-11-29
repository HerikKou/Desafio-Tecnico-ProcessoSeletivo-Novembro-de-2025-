package Desafio_Preco_Justo.Service;

import java.io.ObjectInputFilter.Status;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import Desafio_Preco_Justo.DTO.PatoDTO;
import Desafio_Preco_Justo.Exceptions.NaoEncontrado;
import Desafio_Preco_Justo.Model.Pato;
import Desafio_Preco_Justo.Repository.PatoRepository;
import Desafio_Preco_Justo.Model.StatusPato;
@Service //indica que a classe é um serviço do Spring
public class PatoService {
    
    private final PatoRepository patoRepository;
    public PatoService(PatoRepository patoRepository) {
        this.patoRepository = patoRepository;
    }

    public Pato cadastrarPato(PatoDTO dto) {
        
        Pato pato = new Pato();
        pato.setNome(dto.getNome());
       if(dto.getMae() != null){
         Pato mae = patoRepository.findById(dto.getMae()) .orElseThrow(() -> new NaoEncontrado("Mãe não encontrada"));
        pato.setMae(mae);
    }
      
       pato.setPreco(dto.getPreco());
       pato.setStatusvenda(dto.getStatus());
        return patoRepository.save(pato);
    }
    

}
