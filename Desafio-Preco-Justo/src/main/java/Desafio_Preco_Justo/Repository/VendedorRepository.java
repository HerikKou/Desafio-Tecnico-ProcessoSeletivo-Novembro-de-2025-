package Desafio_Preco_Justo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Desafio_Preco_Justo.Model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByMatricula(String matricula);
  @Query("""
    SELECT v.id, v.nome, COUNT(vd.id) AS totalVendas
    FROM Vendedor v
    LEFT JOIN v.vendas vd
    GROUP BY v.id, v.nome
    ORDER BY totalVendas DESC
""")
List<Object[]> rankingVendedores();

} 