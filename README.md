# 🔹 Aplicação de Cadastro e Consulta de Abastecimentos

## 🛠 Sobre o projeto

Esse projeto faz parte de um desafio criado para uma vaga de Desenvolvedor Júnior. Ele consiste em uma aplicação simples em **Java** para cadastro e consulta de abastecimentos em um posto de combustível, com armazenamento em banco de dados e exibição dos dados via **API REST**.

---

## 📌 Funcionalidades Implementadas

✅ Operaçoes basicas (Criar, Listar, Alterar, Deletar) de **Tipos de Combustível** 
- Nome - Texto
- Preço por litro

✅ Operaçoes basicas (Criar, Listar, Alterar, Deletar) de **Bombas de Combustível** (relacionadas a um tipo de combustível)
- Nome da bomba
- Combustivel que abastece

✅ Operaçoes basicas (Criar, Listar, Alterar, Deletar)  de **Abastecimentos** (com data, volume abastecido e valor total)
- Bomba que foi realizado o abastecimento
- Data do abastecimento
- Quantidade em valores
- Litragem
  
✅ **Consulta** de todos os dados cadastrados (via API)  
✅ Persistência dos dados em banco de dados Postgres  

---

## ✅ Requisitos Atendidos

- Projeto Java com estrutura organizada (usando Maven)
- Relacionamentos entre entidades corretamente implementados
- API HTTP para cadastro e consulta
- Código organizado

---

## 🌟 Diferenciais Implementados

- API RESTful simples com rotas `GET`, `POST`, `PUT`
- Boas práticas de organização de código (DAO, camada de serviço, etc.)
- Persistencia dos dados (em caso de restart da aplicação manter os dados)
- Validação de campos enviados
- Validação de chaves estrangeiras deletadas (SoftDelete)
- SQL com JOINs

## 🏃 Como Rodar o Projeto

1. Crie o arquivo application.properties no caminho src/main/resources/ com o seguinte conteúdo
```
  server.port = 8080
  spring.application.name=Sistema Abastecimentos
  spring.datasource.url=jdbc:postgresql://localhost:5432/seu banco
  spring.datasource.username=Seu usuário
  spring.datasource.password=Sua senha
  spring.datasource.driver-class-name=org.postgresql.Driver
```
2. Crie o banco de dados e as tabelas:
3. Rode o projeto com ``mvn spring-boot:run``
4. A aplicação estará disponível em ``http://localhost:8080``

---
## 🔍 Endpoints

### :zap: Tipos de combustível
  ```
GET    /tipos-combustivel
POST   /tipos-combustivel
PUT    /tipos-combustivel/{id}
DELETE /tipos-combustivel/{id}
  ```
#### Exemplo POST
```
{
  "nome": "Gasolina Aditivada",
  "precoLitro": 5.790
}
```

### :zap: Bombas de combustível
  ```
GET    /bombas-combustivel
POST   /bombas-combustivel
PUT    /bombas-combustivel/{id}
DELETE /bombas-combustivel/{id}
  ```
#### Exemplo POST
```
{
  "nome": "Bomba 01",
  "tipoCombustivelId": 1
}
```

### :zap: Abastecimentos
  ```
GET    /abastecimentos
POST   /abastecimentos
PUT    /abastecimentos/{id}
DELETE /abastecimentos/{id}
  ```
#### Exemplo POST
```
{
	"bombaCombustivelId": 3,
	"data": "01/01/2025",
	"litros": 10
}
```
## 🔥 Aprendizados
- Neste projeto perdi o medo de usar Spring Boot e Spring Web. Apesar de nunca tê-los usado antes, consegui aprender e fazer um projeto bem completo (ao meu ver) utilizando conceitos que aprendi com outras tecnologias. Ao longo do projeto tive um desafio enorme ao utilizar pela primeira vez o ZorinOS para desenvolver, o que me custou algumas horas para "pegar o jeito" do SO.
