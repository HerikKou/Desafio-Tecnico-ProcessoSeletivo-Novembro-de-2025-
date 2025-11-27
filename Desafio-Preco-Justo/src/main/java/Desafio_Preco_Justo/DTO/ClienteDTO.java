package Desafio_Preco_Justo.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {
@NotBlank(message = "O nome não pode ser vazio")
private String nome;
@NotNull(message = "A elegibilidade para desconto não pode ser nula")
private boolean elegivelDesconto;
public ClienteDTO(String nome, boolean elegivelDesconto) {
    this.nome = nome;
    this.elegivelDesconto = elegivelDesconto;
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
