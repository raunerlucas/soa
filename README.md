## Trabalho SOA - Loja de Móveis

Este projeto implementa um Webservice SOAP para gerenciar produtos e móveis de uma loja de móveis, utilizando JAX-WS e JAXB para a comunicação e manipulação de dados em XML.
### Autores

[Rauner & Bruna]

### Funcionalidades

O webservice oferece as seguintes funcionalidades:

- **Listar Produtos:** Retorna uma lista de todos os produtos cadastrados.
- **Listar Produtos Paginados:** Retorna uma lista de produtos de forma paginada, especificando o número da página e a quantidade de produtos por página.
- **Criar Produto:** Cria um novo produto com código, nome, descrição, preço, data de criação e fornecedor. Requer autenticação.
- **Criar Móvel:** Cria um novo móvel, herdando as características de um produto e adicionando material e dimensões. Requer autenticação.
- **Excluir Produto:** Exclui um produto pelo seu código. Requer autenticação.
- **Excluir Móvel:** Exclui um móvel pelo seu código. Requer autenticação.

### Tecnologias Utilizadas

- Java
- JAX-WS (Java API for XML Web Services)
- JAXB (Java Architecture for XML Binding)
- SOAP (Simple Object Access Protocol)
- XML

### Estrutura do Projeto

O projeto está organizado em pacotes:

- **`com.loja_moveis.daos`:** Contém as classes DAO (Data Access Object) responsáveis pela persistência dos dados (`ProdutoDAO`, `MovelDAO`, `FornecedorDAO`).
- **`com.loja_moveis.modelos`:** Contém as classes que representam as entidades do negócio (`Produto`, `Movel`, `Fornecedor`, `Usuario`).
- **`com.loja_moveis.servicos`:** Contém a classe `ProdutosService`, que implementa o webservice SOAP.
- **`com.loja_moveis.tools`:** Contém a classe `Tools` com métodos utilitários.

### Persistência de Dados

Para simplificar, a persistência de dados é simulada utilizando listas em memória (`ArrayList`) dentro das classes DAO. Em um sistema real, seria recomendado utilizar um banco de dados.

### Autenticação

A autenticação é implementada de forma básica, verificando o login e senha do usuário no header da requisição SOAP. As credenciais válidas são `login: soa` e `senha: soa`.

### Execução do Projeto

1. **Compile o projeto:** Utilize um IDE (Eclipse, IntelliJ) ou o comando `javac` para compilar as classes Java.
2. **Execute o webservice:** Execute a classe `ProdutosService`. O serviço estará disponível em `http://localhost:8080/produtos`.

### Testes

Você pode testar o webservice utilizando:

- **SoapUI:** Crie um projeto no SoapUI com o WSDL do serviço (`http://localhost:8080/produtos?wsdl`) e gere requisições para cada método.
- **Postman:** Configure requisições POST com o endpoint `http://localhost:8080/produtos`, header `Content-Type: text/xml` e o corpo da requisição no formato XML. 
- **Qualquer cliente SOAP:** Utilize qualquer cliente SOAP para enviar requisições ao serviço.

### Exemplos de Requisições

**Listar Produtos (GET):**

- URL: `http://localhost:8080/produtos`
- Headers: `Content-Type: text/xml`

**Criar Produto (POST):**

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://servicos.loja_moveis.com/">
   <soapenv:Header>
      <ser:usuario>
         <login>soa</login>
         <senha>soa</senha>
      </ser:usuario>
   </soapenv:Header>
   <soapenv:Body>
      <ser:criarProtudo>
         <produto>
            <codigo>3</codigo>
            <nome>Nome do Produto</nome>
            <descricao>Descrição do Produto</descricao>
            <preco>100.00</preco>
            <dataCriacao>2024-01-01</dataCriacao>
            <fornecedor>
               <cnpj>12345678901234</cnpj>
            </fornecedor>
         </produto>
      </ser:criarProtudo>
   </soapenv:Body>
</soapenv:Envelope>
```

### Observações

- Este projeto é um exemplo didático e pode ser expandido e aprimorado para atender a requisitos mais complexos.
- Implemente a lógica de persistência em um banco de dados real para um sistema em produção.
- Adicione tratamento de erros mais robusto e validações adicionais para aumentar a segurança e confiabilidade do webservice.
- Explore recursos avançados do JAX-WS e JAXB para customizar o comportamento do webservice e a estrutura dos dados XML.

### Contato

[Seu Email]

