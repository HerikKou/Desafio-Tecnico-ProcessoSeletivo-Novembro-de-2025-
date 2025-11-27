package Desafio_Preco_Justo.DTO;

import java.util.List;

public class VendaDTO {
    private Long clienteId;
    private Long vendedorId;
    private List<Long> patoId;
    public VendaDTO() {
    }
    public VendaDTO(Long clienteId, Long vendedorId, List<Long> patoId) {
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.patoId = patoId;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public Long getVendedorId() {
        return vendedorId;
    }
    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }
    public List<Long> getPatoId() {
        return patoId;
    }
    public void setPatoId(List<Long> patoId) {
        this.patoId = patoId;
    }
    
}
