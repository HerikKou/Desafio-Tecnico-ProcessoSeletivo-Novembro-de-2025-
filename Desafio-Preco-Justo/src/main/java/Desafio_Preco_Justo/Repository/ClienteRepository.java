package Desafio_Preco_Justo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Desafio_Preco_Justo.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    
} 
