-- Inserir dados na tabela Usuario
INSERT INTO Usuario (nome, login, senha) VALUES ('João', 'joao', '123');
INSERT INTO Usuario (nome, login, senha) VALUES ('Maria', 'mariao', '456');

-- Inserir dados na tabela Fornecedor
INSERT INTO Fornecedor (cnpj, nomeFantasia, razaoSocial) VALUES ('12.345.678/0001-99', 'Fornecedor A', 'Fornecedor A Ltda');
INSERT INTO Fornecedor (cnpj, nomeFantasia, razaoSocial) VALUES ('98.765.432/0001-88', 'Fornecedor B', 'Fornecedor B S.A.');

-- Inserir dados na tabela Produto
INSERT INTO Produto (nome, descricao, preco, dataCriacao, fornecedor_id) VALUES ('Produto 1', 'Descrição do Produto 1', 100.50, '2023-10-01 10:00:00', 1);
INSERT INTO Produto (nome, descricao, preco, dataCriacao, fornecedor_id) VALUES ('Produto 2', 'Descrição do Produto 2', 200.75, '2023-10-02 11:00:00', 2);

-- Inserir dados na tabela Movel
INSERT INTO Produto (nome, descricao, preco, dataCriacao, fornecedor_id) VALUES ('Mesa de Madeira', 'Mesa de madeira de qualidade', 350.00, '2023-10-03 12:00:00', 1);

-- Supondo que o último ID inserido foi 3, inserimos na tabela Movel com o mesmo ID
INSERT INTO Movel (id, tipo_madeira, dimensoes) VALUES (3, 'Carvalho', '120x60x75');