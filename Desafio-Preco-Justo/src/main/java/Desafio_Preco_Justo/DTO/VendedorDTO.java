package Desafio_Preco_Justo.DTO;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VendedorDTO {
@NotBlank(message = "O nome não pode ser vazio")
private String nome;
@NotBlank(message = "O CPF não pode ser vazio")
@Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
@CPF(message = "CPF inválido")
private String cpf;
@NotBlank(message = "A matrícula não pode ser vazia")
@Size(min = 5, max = 20, message = "A matrícula deve ter entre 5 e 20 caracteres")
private String matricula;
public VendedorDTO(){}//construtor vazio
public VendedorDTO(String nome, String cpf, String matricula) {
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;


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
}
