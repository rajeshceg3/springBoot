# Feature map - Spring Boot Microservices Collection

| Subproject | Purpose | Proven by |
| --- | --- | --- |
| springBoot-jwt | JWT auth service (JPA, security) | package + context-load test |
| springBoot-restapi-crud | Movie CRUD REST API (validation, security) | package + 8 WebMvcTest tests |
| springBoot-kafka-producer / -consumer | Kafka messaging pair | package |
| springBoot-rabbitmq-producer / -consumer | RabbitMQ messaging pair | package |
| springBoot-oauth | OAuth2-secured service | package |
| springBoot-security | Basic auth secured service | package |
| docker-compose/user-service + bank-service | Composed user/bank services | package |

The automated proof lives in `.cursor/skills/verify-springboot-collection/`.
