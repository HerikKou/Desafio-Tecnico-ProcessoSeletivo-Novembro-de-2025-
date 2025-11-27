package Desafio_Preco_Justo.Service;

import java.io.ObjectInputFilter.Status;
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
       double preco = calcularPreco(pato);
       pato.setPreco(preco);
       pato.setStatusvenda(StatusPato.disponivel);
        return patoRepository.save(pato);
    }
    public double calcularPreco(Pato pato) {
    int filhos = patoRepository.countByMae(pato);

    if (filhos == 0) {return 70.0;}
    if (filhos == 1) {return 50.0;}
    if (filhos == 2) {return 25.0;}

    
    return 25.0;
}

}
