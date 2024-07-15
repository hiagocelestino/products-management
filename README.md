## Product Management


Esse projeto trata-se de uma API REST para gerenciamento de produtos e categorias. As tecnologias usadas são:
 - Java
 - Maven
 - Spring Boot
 - SQL Server

### Requisitos
- JDK 21
- Maven
- Docker
- Docker compose
### Instalação

1. Clonar o repositório:
    
    `git clone https://github.com/hiagocelestino/products-management.git`

2. Instalar dependências usando o Maven
3. Verificar se o **application.properties** contém todos valores necessários

#### **SQL SERVER**

1. Rodar o comando:

   `docker compose up -d`
2. Acessar o database que estará disponível na porta **5434**
3. Usando o usuario **SA** e a senha **Teste@123** criar database **product_management**;

### Usando API
1. Inicie a aplicação usando o Maven
2. A API estará acessível em http://localhost:8080


#### Endpoints

**API de Categorias**

```
GET /categories - Retorna todas categorias
GET /categories/{id} - Retorna categoria do ID fornecido
POST /categories - Criação de nova categoria
PUT /categories/{id} - Atualização de categoria do ID fornecido
DELETE /categories/{id} - Deleção de categoria do ID fornecido
GET /categories/{id}/products - Retorna os produtos associado a categoria do ID fornecido
```

**Body**
```JSON
{
  "name": "nome da categoria"
}
```
**API de Produtos**

```
GET /producs - Retorna todos os produtos
GET /producs/{id} - Retorna produto do ID fornecido
POST /producs - Criação de novo produto
PUT /producs/{id} - Atualização do produto do ID fornecido
DELETE /producs/{id} - Deleção do produto do ID fornecido
```

**Body**
```JSON
{
  "name": "nome do produto",
  "price": 80000,
  "description": "descrição do produto",
  "quantity": 10,
  "categoryId": 1
}
```
