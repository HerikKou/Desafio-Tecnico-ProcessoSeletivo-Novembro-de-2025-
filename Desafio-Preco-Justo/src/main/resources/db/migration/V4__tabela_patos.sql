CREATE TABLE pato (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,

    mae_id BIGINT NULL,
    FOREIGN KEY (mae_id) REFERENCES pato(id),

    preco DECIMAL(10,2) NOT NULL,

    statusvenda VARCHAR(20) NOT NULL,

    venda_id BIGINT NULL,
    FOREIGN KEY (venda_id) REFERENCES vendas(id)
);
