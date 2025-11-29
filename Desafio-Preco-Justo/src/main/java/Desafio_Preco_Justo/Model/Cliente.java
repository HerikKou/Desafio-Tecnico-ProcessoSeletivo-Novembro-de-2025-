package Desafio_Preco_Justo.Model;
import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;

@Entity
@Table(name = "cliente")
public class Cliente{
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private Long id;
@NotBlank(message = "O nome não pode ser vazio")
private String nome;
@Column(name = "elegivel")
private boolean elegivelDesconto;
@OneToMany(mappedBy = "cliente")
private List<Vendas> vendas;
public Cliente(){}//construtor vazio
public Cliente(Long id, String nome, boolean elegivelDesconto) {
    this.id = id;
    this.nome = nome;
    this.elegivelDesconto = elegivelDesconto;
    
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public boolean getElegivelDesconto() {
    return elegivelDesconto;
}
public void setElegivelDesconto(boolean elegivelDesconto) {
    this.elegivelDesconto = elegivelDesconto;
}



}