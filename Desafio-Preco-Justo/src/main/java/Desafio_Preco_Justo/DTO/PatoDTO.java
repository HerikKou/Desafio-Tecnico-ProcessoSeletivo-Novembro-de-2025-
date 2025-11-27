package Desafio_Preco_Justo.DTO;

import Desafio_Preco_Justo.Model.StatusPato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import Desafio_Preco_Justo.Model.Pato;
public class PatoDTO {
@NotBlank(message = "O nome do filho não pode ser vazio")
private String nome;
@NotNull(message = "A mãe não pode ser nula")
private Long mae;
public PatoDTO( String nome,Long mae) {
    this.nome = nome;
    this.mae = mae;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public Long getMae() {
    return mae;
}
public void setMae(Long mae) {
    this.mae = mae;
}

}
