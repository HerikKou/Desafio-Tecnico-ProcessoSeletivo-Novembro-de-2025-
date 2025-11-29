package Desafio_Preco_Justo.DTO;

import java.math.BigDecimal;

import Desafio_Preco_Justo.Model.StatusPato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PatoDTO {
   @NotBlank(message = "O nome do filho não pode ser vazio")
    private String nome;

    private Long mae; 

    @NotNull(message = "O preço não pode ser nulo")
    private BigDecimal preco;

    @NotNull(message = "O status não pode ser nulo")
    private StatusPato status;

    public PatoDTO(){}
    public PatoDTO( String nome, Long mae,BigDecimal preco, StatusPato status) {
        this.nome = nome;
        this.mae = mae;
        this.preco = preco;
        this.status = status;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusPato getStatus() {
        return status;
    }

    public void setStatus(StatusPato status) {
        this.status = status;
    }

    
}
