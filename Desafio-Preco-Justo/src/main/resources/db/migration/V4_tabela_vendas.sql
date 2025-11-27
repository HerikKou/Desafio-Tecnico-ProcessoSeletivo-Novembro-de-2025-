CREATE TABLE vendas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_venda DATE NOT NULL,
    cliente_id BIGINT NOT NULL,
    vendedor_id BIGINT NOT NULL,
    
    FOREIGN KEY(cliente_id) REFERENCES cliente(id),
    FOREIGN KEY(vendedor_id) REFERENCES vendedor(id),
    
);