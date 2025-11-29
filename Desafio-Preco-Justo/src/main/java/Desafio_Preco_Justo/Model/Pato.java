package Desafio_Preco_Justo.Model;
import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pato")
public class Pato{
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private Long id;
@NotBlank(message = "O nome do filho não pode ser vazio")
private String nome;
@ManyToOne
@JoinColumn(name = "mae_id")
private Pato mae;
@NotNull(message = "O preço não pode ser nulo")
private BigDecimal preco;
@Column(name = "statusvenda")
@Enumerated(EnumType.STRING)
private StatusPato statusvenda;
@ManyToOne
@JoinColumn(name = "venda_id")
private Vendas venda;
public Pato(){}
public Pato(Long id, String nome, Pato mae, BigDecimal preco, StatusPato statusvenda) {
    this.id = id;
    this.nome = nome;
    this.mae = mae;
    this.preco = preco;
    this.statusvenda = statusvenda;
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
public Pato getMae() {
    return mae;
}
public void setMae(Pato mae) {
    this.mae = mae;
}
public BigDecimal getPreco() {
    return preco;
}
public void setPreco(BigDecimal preco) {
    this.preco = preco;
}
public StatusPato getStatusvenda() {
    return statusvenda;
}
public void setStatusvenda(StatusPato statusvenda) {
    this.statusvenda = statusvenda;
}
public Vendas getVenda() {
    return venda;
}
public void setVenda(Vendas venda) {
    this.venda = venda;
}


}