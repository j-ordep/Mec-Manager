# MecManager - Sistema de Gerenciamento para Oficinas Mecânicas

O MecManager é uma API REST desenvolvida para auxiliar oficinas mecânicas no gerenciamento de clientes, veículos e ordens de serviço. O sistema permite cadastrar clientes, veículos, associar veículos aos clientes, criar e acompanhar ordens de serviço, entre outras funcionalidades.

## Links do Projeto

- [Diagrama no Excalidraw](https://excalidraw.com/#room=a1b010f61abb7fbcd727,F2HNiTMOlG6xtLmDKpWFsA)
- [Documentação Visual](https://excalidraw.com/#json=bWOuMEfHEgb3H-npiox8M,CJU8hbG86VFHOCK2s1uppw)

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Flyway**
- **Lombok**
- **Docker**
- **Maven**

## Estrutura do Projeto

O projeto está estruturado seguindo uma arquitetura em camadas:

### Entidades

- **Car**: Representa um veículo com informações como placa, modelo, ano, etc.
- **Client**: Representa um cliente da oficina com informações pessoais e de contato.
- **ClientCar**: Entidade associativa entre cliente e carro, representando os veículos de cada cliente.
- **WorkOrder**: Representa uma ordem de serviço com detalhes sobre o serviço realizado, custo, status, etc.

### DTOs (Data Transfer Objects)

- **Request**: Objetos usados para receber dados nas requisições da API
  - CarRequest
  - WorkOrderRequest
  
- **Response**: Objetos usados para retornar dados nas respostas da API
  - CarResponse
  - WorkOrderResponse

### Mappers

Classes responsáveis por converter entidades em DTOs e vice-versa:
- **CarMapper**: Conversão entre Car, CarRequest e CarResponse
- **ClientMapper**: Conversão entre Client e seus respectivos DTOs
- **WorkOrderMapper**: Conversão entre WorkOrder, WorkOrderRequest e WorkOrderResponse

### Repositórios

Interfaces para acesso aos dados no banco:
- **CarRepository**
- **ClientRepository**
- **WorkOrderRepository**

### Serviços

Camada que implementa a lógica de negócios:
- **CarService**: Gerenciamento de veículos
- **ClientService**: Gerenciamento de clientes
- **WorkOrderService**: Gerenciamento de ordens de serviço

### Controladores

Endpoints da API REST:
- **CarController**: Endpoints para gerenciamento de veículos
- **ClientController**: Endpoints para gerenciamento de clientes
- **WorkOrderController**: Endpoints para gerenciamento de ordens de serviço

### Enums

- **WorkStatus**: Representa os possíveis estados de uma ordem de serviço (PENDING, IN_PROGRESS, COMPLETED, CANCELED)

## Como Executar o Projeto

### Pré-requisitos

- Docker e Docker Compose instalados
- Java 17
- Maven

### Executando localmente

1. Clone o repositório:
```bash
git clone [URL_DO_REPOSITORIO]
cd mec-manager
```

2. Inicie o banco de dados PostgreSQL usando Docker Compose:
```bash
docker-compose up -d
```

3. Execute a aplicação Spring Boot:
```bash
./mvnw spring-boot:run
```

4. A aplicação estará disponível em: `http://localhost:8080`

## API Endpoints

### Carros
- `GET /mecmanager/car`: Lista todos os carros
- `GET /mecmanager/car/{id}`: Busca carro por ID
- `GET /mecmanager/car/{licensePlate}`: Busca carro por placa
- `POST /mecmanager/car`: Cadastra um novo carro
- `DELETE /mecmanager/car/{id}`: Remove um carro

### Clientes
- `GET /mecmanager/client`: Lista todos os clientes
- `GET /mecmanager/client/{id}`: Busca cliente por ID
- `POST /mecmanager/client`: Cadastra um novo cliente
- `DELETE /mecmanager/client/{id}`: Remove um cliente

### Ordens de Serviço
- `GET /mecmanager/workorder`: Lista todas as ordens de serviço
- `GET /mecmanager/workorder/{id}`: Busca ordem de serviço por ID
- `POST /mecmanager/workorder`: Cria uma nova ordem de serviço
- `PUT /mecmanager/workorder/{id}`: Atualiza uma ordem de serviço
- `DELETE /mecmanager/workorder/{id}`: Remove uma ordem de serviço

## Configuração do Banco de Dados

A configuração do banco de dados está no arquivo `application.properties`:

```properties
spring.application.name=mec-manager
spring.datasource.url=jdbc:postgresql://localhost:5433/mecmanager
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true

spring.flyway.enabled=true
```

## Boas Práticas Implementadas

1. **Separação entre Entidades e DTOs**: Evita referências circulares e exposição indevida de dados.
2. **Uso de Mappers**: Converte entidades para DTOs e vice-versa de forma padronizada.
3. **Validação de Dados**: Implementada nas entidades e DTOs.
4. **Versionamento de Banco**: Uso do Flyway para controle de versão do esquema de banco de dados.
5. **Design RESTful**: API projetada seguindo os princípios REST.

## Próximos Passos e Melhorias

- Implementação de autenticação e autorização
- Adição de testes automatizados
- Documentação da API com Swagger/OpenAPI
- Implementação de logs e monitoramento
- Frontend para interação com a API

## Contribuição

Para contribuir com o projeto, siga os passos:

1. Faça um fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Faça commit das suas alterações (`git commit -m 'Adiciona nova funcionalidade'`)
4. Faça push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request
