# Floricultura Dica 🌷

Sistema desktop de gestão para uma floricultura, desenvolvido em Java como projeto do curso **Programador de Sistemas – Senac PR (2026)**.

## Funcionalidades

- Cadastro, consulta, alteração e exclusão de **clientes**
- Cadastro, consulta, alteração e exclusão de **categorias**
- Cadastro, consulta, alteração e exclusão de **produtos**
- Interface com menus em Java Swing

## Tecnologias

- Java (Swing)
- JPA / Hibernate 5.4
- MySQL 8
- Maven

## Estrutura

```
src/main/java
├── model   → entidades mapeadas com JPA (Clientes, Categorias, Produtos, Pedidos...)
├── dao     → classes de acesso ao banco (padrão DAO)
├── util    → JPAUtil, que cria a conexão com o banco
└── view    → telas e menus em Swing (JanelaPrincipal, Main)
```

## Como executar

1. Tenha o **MySQL** rodando e crie o banco:
   ```sql
   CREATE DATABASE floriculturalinda;
   ```
2. Em `src/main/resources/META-INF/persistence.xml`, ajuste a porta, o usuário e troque `SUA_SENHA` pela senha do seu MySQL.
3. Abra o projeto no IntelliJ IDEA (ou outra IDE com Maven) e execute a classe `view.Main`.

As tabelas são criadas automaticamente pelo Hibernate na primeira execução.

## Autor

João Victor Barlati
