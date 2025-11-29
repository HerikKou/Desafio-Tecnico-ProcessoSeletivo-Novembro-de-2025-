CREATE TABLE vendas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_venda DATETIME NOT NULL,

    cliente_id BIGINT,
    vendedor_id BIGINT,

    FOREIGN KEY(cliente_id) REFERENCES cliente(id),
    FOREIGN KEY(vendedor_id) REFERENCES vendedor(id)
);
