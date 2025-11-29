package Desafio_Preco_Justo.Model;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Vendedor {
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private Long id;
@NotBlank(message = "O nome não pode ser vazio")
private String nome;
@NotBlank(message = "O CPF não pode ser vazio")
@Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")

private String cpf;
@NotBlank(message = "A matrícula não pode ser vazia")
@Size(min = 5, max = 20, message = "A matrícula deve ter entre 5 e 20 caracteres")
private String matricula;
@OneToMany(mappedBy = "vendedor")
private List<Vendas> vendas;
public Vendedor(){}//construtor vazio
public Vendedor(Long id, String nome, String cpf, String matricula, List<Vendas> vendas) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;
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
public String getCpf() {
    return cpf;
}
public void setCpf(String cpf) {
    this.cpf = cpf;
}
public String getMatricula() {
    return matricula;
}
public void setMatricula(String matricula) {
    this.matricula = matricula;
}
public List<Vendas> getVendas() {
    return vendas;
}
public void setVendas(List<Vendas> vendas) {
    this.vendas = vendas;
}

}
