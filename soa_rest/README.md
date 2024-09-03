# Loja de Móveis REST

1) Escolher um tema de um problema de sistema de informação a ser tratado computacionalmente, como por exemplo uma livraria (exemplo do livro).

2) Fazendo uma análise rápida do negócio escolhido, selecionar duas classes de negócio que se relacionem por uma agregação, como as classes Livro e Autor, do texto. O relacionamento não pode ser 1 para 1. Pode ser 1 para n ou n para n. Esta análise deve determinar os atributos das classes e seus tipos de dados.

3) Implementar as classes selecionadas em Java nos padrões do que foi exposto em sala, usando Spring Boot e fazendo uso do banco de dados H2. Estas classes devem substituir Livro e Autor no código.

4) Modificar o código implementando um webservice de um CRUD usando REST que permita a cada uma das duas classes:

4.1) a exibição de todos os objetos da classe, mostrando também os dados da outra classe no caso da classe principal. 

4.2) a exibição de um elemento individual da classe, mediante a passagem de algum parâmetro para o webservice como o id (identificador único do objeto, chave primária do banco).

4.3) a inserção de outros objetos das classes passados como parâmetro no corpo da chamada ao serviço.

4.4) a exclusão de elementos das tabelas com base em um id passado na URL.

4.5) a alteração de um elemento das tabelas com base em um id passado na URL e dados passados como parâmetro no corpo da chamada ao serviço.

5) O resultado final deve ser um webservice usando REST que será testado usando a ferramenta SOAPUI ou a interface swagger-ui (incluir a dependência springdoc-openapi-starter-webmvc-ui). 

6) Observações:

6.1) O código disponibilizado já implementa todas as funcionalidades acima para Livro e Autor.

6.2) Se quiser verificar a parte do banco de dados H2, alterar o application.properties da seguinte forma:

6.2.1) trocar a url de conexão ao banco para "spring.datasource.url=jdbc:h2:file:~/test" (sem as áspas). Isso deixa o banco persistente em arquivo.

6.2.2) Acrestentar as linhas abaixo:

# Enabling H2 Console

spring.h2.console.enabled=true

# Custom H2 Console URL

spring.h2.console.path=/h2-console

6.2.3) Com isso é possivel acessar o banco H2 por uma interface WEB no endereço http://localhost:8080/h2-console . Esta interface é parecida com a interface do MySQL Workbench.

Regras:

a) por mais óbvio que seja, as classes Livro e Autor não podem usadas no trabalho a ser entregue;

b) preferencialmente em duplas ou trios. Grupos com mais de 3 estudantes não serão aceitos. Sugestão: manter o mesmo grupo do trabalho de SOAP.

c) valor: 100 pontos.

d) os grupos devem divulgar o tema no grupo do WhatsApp. Temas iguais serão considerados COLA e a nota será dividida entra os grupos. 

Extras:

a) implementar classes com relacionamento n por n bidirecional, com Lista dos elementos da outra classe em cada classe, vale mais 50%. Neste caso tem que resolver o problema de loop do JSON.
