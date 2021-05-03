<h1 align="center">
Desafio de desenvolvimento Java
</h1>

<p align="center">
  Criar uma API para uma seguradora de veículos.
</p>

<p align="center">
  <a href="#page_with_curl-sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#books-dependencias">Dependencias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#star-requisitos">Requisitos</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;  
  <a href="#rocket-começando">Começando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#computer-iniciando-o-projeto">Iniciando o projeto</a>&nbsp;&nbsp;&nbsp;
</p>

## :page_with_curl: Sobre
Este repositório contém uma arquitetura em API Rest desenvolvida com Java e Spring Boot, MongoDB para a persistência de dados, Swagger para a documentação dos endpoints e models, e por fim, o hibernate-validator e spring-validation para fazer as validações.

## :books: **Dependencias**


**spring-boot-starter-web**: Utilizado para tornar a aplicação web.

**spring-boot-starter-data-mongodb**: Utilizado para fazer a integração com o MongoDB e gerenciar a persistência de dados do sistema.

**spring-boot-starter-validation**: Utilizado para as validações dos Models, DTOs, etc.

**hibernate-validator**: Utilizado para validação de CPF.

**springfox-swagger**: Utilizado para documentar a Api.

**spring-boot-devtools**: Utilizado para o LiveReload do servidor


## :star: Requisitos
- Ter [**Git**](https://git-scm.com/) para clonar o projeto.
- Ter [**Java 8**](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html) instalado.
- Ter [**MongoDB**](https://www.mongodb.com/try/download/community) instalado.


## :rocket: Começando
``` bash
  # Clonar o projeto:
  $ git clone https://github.com/EltonRiva1/desafio-asap-log.git

  # Entrar no diretório do projeto:
  $ cd desafio-asap-log
```

## :computer: Iniciando o Projeto
```bash
  # Instalar as dependências:
  $ mvn clean install

  # Rodar a aplicação:
  $ mvn spring-boot:run
```

