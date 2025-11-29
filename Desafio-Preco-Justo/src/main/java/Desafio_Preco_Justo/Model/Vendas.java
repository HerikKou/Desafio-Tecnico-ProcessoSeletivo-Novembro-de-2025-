package Desafio_Preco_Justo.Model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "vendas")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "venda")
    private List<Pato> patos;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;
    private LocalDate dataVenda;
    public Vendas() {
    }
    public Vendas(Long id, Cliente cliente, List<Pato> patos, Vendedor vendedor, LocalDate dataVenda) {
        this.id = id;
        this.cliente = cliente;
        this.patos = patos;
        this.vendedor = vendedor;
        this.dataVenda = dataVenda;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Pato> getPatos() {
        return patos;
    }
    public void setPatos(List<Pato> patos) {
        this.patos = patos;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public LocalDate getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    

    

}
