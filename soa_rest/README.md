## Documentação do Projeto Loja de Móveis (SOA REST)

### Descrição do Projeto

Este projeto implementa um sistema de gerenciamento de Loja de Móveis utilizando uma arquitetura orientada a serviços (SOA) com REST. Ele fornece APIs RESTful para gerenciar clientes, produtos, pedidos e pagamentos. 

O projeto está dividido em diferentes módulos, cada um responsável por uma funcionalidade específica:

- **com.loja_moveis.model**: Contém as classes de modelo que representam as entidades do sistema, como Cliente, Produto, Pedido, etc.
- **com.loja_moveis.service**: Contém a lógica de negócios do sistema, implementada como serviços.
- **com.loja_moveis.controller**: Contém os controladores REST que expõem os serviços como APIs RESTful.
- **com.loja_moveis.repository**: Contém as interfaces que definem as operações de acesso a dados para cada entidade. 
- **com.loja_moveis.exception**: Contém as classes de exceção personalizadas do sistema.
- **com.loja_moveis.config**: Contém as configurações do projeto, como configuração do banco de dados.

### Tecnologias Utilizadas

- **Java 11:** Linguagem de programação principal.
- **Spring Boot:** Framework para desenvolvimento de aplicações web.
- **Spring Data JPA:** Simplifica o acesso a dados com JPA.
- **Maven:** Gerenciamento de dependências.
- **Swagger:** Documentação das APIs REST.

### Estrutura do Banco de Dados

O projeto utiliza um banco de dados relacional para armazenar os dados. A estrutura do banco de dados é composta pelas seguintes tabelas:

- **cliente:** Armazena informações sobre os clientes, como nome, CPF e endereço.
- **produto:** Armazena informações sobre os produtos, como nome, descrição e preço.
- **pedido:** Armazena informações sobre os pedidos, como data do pedido e cliente que realizou o pedido.
- **item_pedido:** Armazena informações sobre os itens de um pedido, como produto e quantidade.
- **pagamento:** Armazena informações sobre os pagamentos, como forma de pagamento e status.

### Como executar o projeto

1. **Clonar o repositório:** 
```
git clone https://github.com/raunerlucas/soa.git
```

2. **Navegar até o diretório do projeto:**
```
cd soa/soa_rest
```

3. **Construir o projeto com Maven:**
```
mvn clean install
```

4. **Executar a aplicação Spring Boot:**
```
mvn spring-boot:run
```

5. **Acessar a documentação do Swagger:**
```
http://localhost:8080/swagger-ui/index.html
```

## Modelo de README.md

```markdown
# Sistema de Loja de Móveis (SOA REST)

## Descrição

Este projeto implementa um sistema de gerenciamento de Loja de Móveis utilizando uma arquitetura orientada a serviços (SOA) com REST. Ele fornece APIs RESTful para gerenciar clientes, produtos, pedidos e pagamentos. 

## Tecnologias

* Java 11
* Spring Boot
* Spring Data JPA
* Maven
* Swagger

## Arquitetura

![Arquitetura SOA](./diagrama-arquitetura.png)

## Funcionalidades

* **Gerenciamento de Clientes:** Criar, listar, atualizar e excluir clientes.
* **Gerenciamento de Produtos:** Criar, listar, atualizar e excluir produtos.
* **Gerenciamento de Pedidos:** Criar, listar, atualizar e excluir pedidos.
* **Gerenciamento de Pagamentos:** Criar, listar, atualizar e excluir pagamentos.

## Como Executar

1. Clone o repositório: `git clone https://github.com/raunerlucas/soa.git`
2. Navegue até o diretório do projeto: `cd soa/soa_rest`
3. Construa o projeto: `mvn clean install`
4. Execute a aplicação: `mvn spring-boot:run`
5. Acesse a documentação do Swagger: `http://localhost:8080/swagger-ui/index.html`

## Autor

* [Rauner Lucas](https://github.com/raunerlucas)

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
```
