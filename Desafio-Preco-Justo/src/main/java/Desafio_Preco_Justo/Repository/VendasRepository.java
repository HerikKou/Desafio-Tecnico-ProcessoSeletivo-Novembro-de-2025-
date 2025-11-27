package Desafio_Preco_Justo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Desafio_Preco_Justo.Model.Vendas;

public interface VendasRepository extends JpaRepository<Vendas, Long> {
  
}
