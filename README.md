# Documento de apresentação API listaservice_V2

# Objetivo

 Apresentar o Backend de uma  API  de listagem de serviços disponibilizados pelos próprios usuários do sistema.

# Ferramentas:

- Linguagem utilizada Java 17, JDK - Spring Boot;
- IDE: STS - Spring Tools 4 Suite;
- Banco de dados: MySQL;
- IDE do banco de dados: MySQL Workbench;
- Acesso a internet e navegador WEB.

# Dependências:

- Spring Web;
- Spring Boot DevTools;
- Spring Data JPA;
- MySQL driver;
- Lombok;
- Dozer;
- Swagger ;
- Flyway.

# Sobre a API

## Padrões de Projeto

### Model

Foram criadas cinco entidades modelos com cada uma possuindo os  seus respectivos atributos e  métodos gets e sets gerados automaticamente pelo lombok.

## São elas:

### Cliente

Atributos:			
- long id;		 	
- String nome;
- String email;		
- String endereço;
- String Login;
- String password;


### Colaborador

Atributos:

- long id;		 	
- String nome;
- String matricula;		
- String status;
- String Login;
- String password;


### Serviço

Atributos:

- long id;		 	
- String nome;
- String descrição;		
- String status;


### Categoria

Atributos:

- long id;		 	
- String nome;
- String descricao;		
- String status;
- String adicional;


### Pagamentos

Atributos:

- long id;		 	
- String nome;
- String numero;		
- String agência;
- String codigoSegurança;





## Repository

Seguindo os conceitos deste padrão, dividimos a API nas seguintes camadas.

### Data - model

Representa as entidades;

### Service 
Contém a lógica de negócios;

### Controller

Gerencia as requisições da interface do usuário;

### Repository

Responsável pelas operações de acesso a dados, isolando-as das outras camadas.

## DTO

O padrão DTO foi aplicado na camada modelo e assim ,ajudou a desacoplar a comunicaçao entre a camada de modelo da camada de serviço e de controller a ainda foi útil para exibir ao usuário apenas os dados necessários. Sua estrutura foi a seguinte:

- data.model ( com a entidade de negócio);

- data.DTO ( com a entidade __DTO  e  __LowDTO)

## Base de dados

Todo o DDL das tabelas das entidades foram executados via Migration.
Através do caminho resources/db/migrations , e com as seguintes DDLs:

- V1__Create_Cliente_Table.sql
- V1_1__Create_Colaborador_Table.sql
- V1_2__Create_Servico_Table.sql
- V1_3__Create_Categoria_Table.sql
- V1_4__Create_Pagamento_Table.sql

## Acesso aos métodos CRUD

O acesso aos métodos da API foram realizados através do framework swagger no navegador web, através do endereço web :  http://localhost:8080/swagger-ui/index.html

### Entidade Cliente

- GET: /api/v1/cliente
- GET /api/v1/cliente/all
- PUT: /api/v1/cliente
- POST: /api/v1/cliente
- DELETE: /api/v1/cliente/{id}

### Entidade Serviço

- GET: /api/v1/servico
- GET /api/v1/servico/all
- PUT: /api/v1/servico
- POST: /api/v1/servico
- DELETE: /api/v1/servico/{id}

### Entidade Colaborador

- GET: /api/v1/colaborador
- GET /api/v1/colaborador/all
- PUT: /api/v1/colaborador
- POST: /api/v1/colaborador
- DELETE: /api/v1/colaborador/{id}

### Entidade Categoria

- GET: /api/v1/categoria
- GET /api/v1/categoria/all
- PUT: /api/v1/categoria
- POST: /api/v1/categoria
- DELETE: /api/v1/categoria/{id}

### Entidade Pagamento

- GET: /api/v1/pagamento
- GET /api/v1/pagamento/all
- PUT: /api/v1/pagamento
- POST: /api/v1/pagamento
- DELETE: /api/v1/pagamento/{id}

## Acesso ao Banco de dados

O arquivo de configuração do banco de dados MySQL  estão em src/main/resources/applications.properties, neste arquivo estão as credencias de acesso ao SGBD e a configuração de migration do flyway.

### base de dados: MySQL
### usuário: root
### password: 123456 



