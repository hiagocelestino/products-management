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

**OBS:** O endpoint **GET /categories** pode ser filtrado passando o query param **name**

**API de Produtos**

```
GET /products - Retorna todos os produtos
GET /products/{id} - Retorna produto do ID fornecido
POST /products - Criação de novo produto
PUT /products/{id} - Atualização do produto do ID fornecido
DELETE /products/{id} - Deleção do produto do ID fornecido
```
**OBS:** A rota de **GET /products** pode ser ordenada e paginada com os seguintes parâmetros:
pageNo: número da página buscada
pageSize: quantidade de itens por página
sortBy: campo que deve ser usada para ordernar
sortDirection: direção de ordenação: asc ou desc


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

### Observações:
   - Existe um arquivo na raiz do projeto com queries para popular o banco com alguns dados
   - Dentro da pasta postman existe uma collection pronta com todos endpoints, sendo necessário apenas importar
   - Testes não foram implementados
   - Tratamentos de exceções não foram implementados
   
