package Desafio_Preco_Justo.Service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import Desafio_Preco_Justo.DTO.VendaDTO;

import Desafio_Preco_Justo.Exceptions.NaoEncontrado;
import Desafio_Preco_Justo.Model.Cliente;
import Desafio_Preco_Justo.Model.Pato;
import Desafio_Preco_Justo.Model.StatusPato;
import Desafio_Preco_Justo.Model.Vendas;
import Desafio_Preco_Justo.Model.Vendedor;
import Desafio_Preco_Justo.Repository.ClienteRepository;
import Desafio_Preco_Justo.Repository.PatoRepository;
import Desafio_Preco_Justo.Repository.VendasRepository;
import Desafio_Preco_Justo.Repository.VendedorRepository;

@Service
public class VendaService {
    
    private final VendasRepository vendasRepository;
    private final ClienteRepository clienteRepository;
    private final VendedorRepository vendedorRepository;
    private final PatoRepository patoRepository;
 
    public VendaService(VendasRepository vendasRepository,ClienteRepository clienteRepository, VendedorRepository vendedorRepository, PatoRepository patoRepository) {
       
        this.vendasRepository = vendasRepository;
        this.clienteRepository = clienteRepository;
        this.vendedorRepository = vendedorRepository;
        this.patoRepository = patoRepository;
    }
   
    public Vendas registrarVenda(VendaDTO vendadto) {
     Cliente cliente = clienteRepository.findById(vendadto.getClienteId()).orElseThrow(() -> new NaoEncontrado("Cliente não encontrado"));
     Vendedor vendedor = vendedorRepository.findById(vendadto.getVendedorId()).orElseThrow(() -> new NaoEncontrado("Vendedor não encontrado"));

     Vendas venda = new Vendas();
    venda.setCliente(cliente);
    venda.setVendedor(vendedor);
    venda.setDataVenda(LocalDate.now());
   List<Pato> patos = vendadto.getPatoId().stream()
        .map(id -> {
            Pato pato = patoRepository.findById(id).orElseThrow(() -> new NaoEncontrado("Pato com ID " + id + " não encontrado"));
            return pato;
        })
        .collect(Collectors.toList());

    
    for (Pato pato : patos) {
        if(pato.getStatusvenda() == StatusPato.vendido){
            throw new NaoEncontrado("Pato com ID " + pato.getId() + " já foi vendido");
        }
        pato.setStatusvenda(StatusPato.vendido);
        pato.setVenda(venda);
       
    }
    venda.setPatos(patos);
    return vendasRepository.save(venda);
}


public List<Vendas> obterTodasVendas() {
    return vendasRepository.findAll();
}

    public ByteArrayInputStream gerarRelatorio(){
        try (Workbook workbook = new XSSFWorkbook()) {

        Sheet sheet = workbook.createSheet("Relatório de Vendas");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Cliente");
        header.createCell(1).setCellValue("Vendedor");
        header.createCell(2).setCellValue("Data");
        header.createCell(3).setCellValue("Quantidade de Patos");

        List<Vendas> vendas = vendasRepository.findAll();

        int rowIdx = 1;
        for (Vendas v : vendas) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(v.getCliente().getNome());
            row.createCell(1).setCellValue(v.getVendedor().getNome());
            row.createCell(2).setCellValue(v.getDataVenda().toString());
            row.createCell(3).setCellValue(v.getPatos().size());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);

        return new ByteArrayInputStream(out.toByteArray());

    } catch (Exception e) {
        throw new RuntimeException("Erro ao gerar Excel");
    }

    }





}
