package Desafio_Preco_Justo.Model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Cliente{
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private Long id;
@NotBlank(message = "O nome não pode ser vazio")
private String nome;
@Enumerated(EnumType.STRING)
private boolean elegivelDesconto;
@OneToMany(mappedBy = "cliente")
private List<Vendas> vendas;
public Cliente(){}//construtor vazio
public Cliente(Long id, String nome, boolean elegivelDesconto, List<Vendas> vendas) {
    this.id = id;
    this.nome = nome;
    this.elegivelDesconto = elegivelDesconto;
    this.vendas = vendas;
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
public List<Vendas> getVendas() {
    return vendas;
}
public void setVendas(List<Vendas> vendas) {
    this.vendas = vendas;
}


}