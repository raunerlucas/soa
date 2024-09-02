CREATE TABLE Usuario (
    id INT IDENTITY,
    nome VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Fornecedor (
    id INT IDENTITY,
    cnpj VARCHAR(20) NOT NULL,
    nomeFantasia VARCHAR(255) NOT NULL,
    razaoSocial VARCHAR(255) NOT NULL
);

CREATE TABLE Produto (
    id INT IDENTITY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    preco DOUBLE NOT NULL,
    dataCriacao TIMESTAMP,
    fornecedor_id INT,
    CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES Fornecedor(id)
);

CREATE TABLE Movel (
    id INT IDENTITY,
    tipo_madeira VARCHAR(255),
    dimensoes VARCHAR(255),
    CONSTRAINT fk_produto FOREIGN KEY (id) REFERENCES Produto(id)
);