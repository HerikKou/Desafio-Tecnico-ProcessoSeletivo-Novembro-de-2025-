package Desafio_Preco_Justo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import Desafio_Preco_Justo.Repository.VendedorRepository;
import Desafio_Preco_Justo.Model.Vendedor;
import Desafio_Preco_Justo.DTO.VendedorDTO;
import Desafio_Preco_Justo.DTO.VendedorRankingDTO;
import Desafio_Preco_Justo.Exceptions.*;
@Service
public class VendedorService {

   
    private final VendedorRepository vendedorRepository;
    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
      
    }
    public Vendedor cadastrarVendedor(VendedorDTO vendedordto) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(vendedordto.getNome());
        if(vendedorRepository.existsByCpf(vendedordto.getCpf())){
           throw new Existe("Já existe um vendedor com esse CPF");
        }
        if(vendedorRepository.existsByMatricula(vendedordto.getMatricula())){
             throw new Existe("Já existe um vendedor com essa matricula");
        }
        vendedor.setCpf(vendedordto.getCpf());
        vendedor.setMatricula(vendedordto.getMatricula());
        return vendedorRepository.save(vendedor);
        
        
    }
   public List<VendedorRankingDTO> ranking() {

    List<Object[]> resultado = vendedorRepository.rankingVendedores();

    return resultado.stream()
            .map(row -> new VendedorRankingDTO(
                    (Long) row[0],
                    (String) row[1],
                    ((Long) row[2]).intValue()
            ))
            .toList();
}

}
