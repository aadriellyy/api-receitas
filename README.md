# 🍽️ API de Receitas

Uma API RESTful desenvolvida com Spring Boot para gerenciamento de receitas culinárias e seus ingredientes.

## 🧾 Funcionalidades

- CRUD de **Ingredientes**
- CRUD de **Receitas**
- Associação de ingredientes com quantidades em cada receita
- Descrição do modo de preparo de forma simples
- Banco de dados **H2 em memória** para facilitar testes

## 🔧 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Maven

## 📁 Estrutura do Projeto

src/ ├── main/ │ ├── java/com/seuusuario/receitas/ │ │ ├── controller/ │ │ ├── dto/ │ │ ├── entity/ │ │ ├── repository/ │ │ └── service/ │ └── resources/ │ ├── application.properties │ └── data.sql

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/api-receitas.git
   cd api-receitas

2. Compile e rode o projeto:
    ```bash
    ./mvnw spring-boot:run

3. Acesse a aplicação:
    - API: http://localhost:8080

    - Console H2: http://localhost
        - JDBC URL: jdbc:h2:mem:receitasdb
        - User: sa
        - Senha: (deixe em branco)


## 📬 Exemplos de Requisições

### Criar ingrediente
    - Rota: POST /ingrediente

    ```json
    {
    "nome": "Açúcar",
    "unidadeMedida": "gramas"
    }

### Criar Receita
    - Rota: POST /receitas

    ```json
    {
    "nome": "Bolo de Chocolate",
    "modoPreparo": "Misture tudo e asse por 40 minutos.",
    "ingredientes": [
        { "ingredienteId": 1, "quantidade": 200.0 },
        { "ingredienteId": 2, "quantidade": 100.0 }
        ]
    }

## Desenvolvido por Adrielly Lima 💙
