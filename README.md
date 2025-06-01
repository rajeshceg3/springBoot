# Spring Boot Microservices Collection

This project contains a collection of Spring Boot microservices.

## Architecture

The project is structured as a microservices architecture. Key services include:
- **User Service (`springBoot-docker-compose/user-service`):** Manages user-related operations.
- **Bank Service (`springBoot-docker-compose/bank-service`):** Manages banking operations and likely depends on the User Service.
- *(More services will be listed here as they are identified)*

## Prerequisites


- Java: Most services use Java 11, but some (e.g., `springBoot-restapi-crud`, `springBoot-security`) use Java 8. Ensure the correct JDK is available for the service you intend to run.

- Java 11 (or later)

- Apache Maven
- Docker
- Docker Compose

## How to Run (Core Services)

The primary way to run the core services (`user-service` and `bank-service`) is by using Docker Compose.

1.  **Navigate to the `springBoot-docker-compose` directory:**
    ```bash
    cd springBoot-docker-compose
    ```
2.  **Build and run the services using Docker Compose:**
    ```bash
    docker-compose up --build
    ```
3.  **Accessing the services:**
    -   User Service: `http://localhost:8081`
    -   Bank Service: `http://localhost:8083`

## Other Services

This repository contains several other Spring Boot applications, including:
-   **`springBoot-jwt`**: This service likely handles JWT-based authentication and authorization. It expects a username and password for generating tokens. It uses Spring Boot 2.7.2 and Java 11.
    -   To run: `cd springBoot-jwt && mvn spring-boot:run`
-   **`springBoot-kafka-producer`**: This service acts as a Kafka producer. It exposes a POST endpoint at `/publish` which accepts a JSON object representing a movie (with `name` and `director` fields). This movie data is then published to a Kafka topic named `imdb`. It uses Spring Boot 2.2.6.RELEASE and Java 11.
    -   To run: `cd springBoot-kafka-producer && mvn spring-boot:run`
    -   Example Usage: `curl -X POST -H "Content-Type: application/json" -d '{"name":"My Movie", "director":"Some Director"}' http://localhost:8080/publish` (Assuming default port 8080 if not specified elsewhere)
-   **`springBoot-kafka-consumer`**: This service is likely the consumer for the messages published by `springBoot-kafka-producer`, subscribing to the `imdb` topic to process movie data. (Further details to be added if this service is explored).
    -   To run: `cd springBoot-kafka-consumer && mvn spring-boot:run`

-   **`springBoot-oauth`**: Implements OAuth2 functionalities, likely acting as an authorization server or client. Uses Spring Boot 2.3.1.RELEASE and Java 11. Dependencies include `spring-cloud-starter-oauth2`.
    -   To run: `cd springBoot-oauth && mvn spring-boot:run`
-   **`springBoot-rabbitmq-producer`**: This service acts as a RabbitMQ producer. It exposes a POST endpoint at `/publish` which accepts a JSON object with a `message` field (e.g., `{"message":"Hello World"}`). This message, along with a system-generated ID and date, is then published as JSON to a RabbitMQ exchange named `message_exchange` with the routing key `message_routingkey`, ultimately intended for a queue named `message_queue`. It uses Spring Boot 2.4.2 and Java 11.
    -   To run: `cd springBoot-rabbitmq-producer && mvn spring-boot:run`
    -   Example Usage: `curl -X POST -H "Content-Type: application/json" -d '{"message":"Your message content here"}' http://localhost:8080/publish` (Assuming default port 8080 if not specified elsewhere)
-   **`springBoot-rabbitmq-consumer`**: This service is likely the consumer for the messages published by `springBoot-rabbitmq-producer`, subscribing to `message_queue` to process incoming messages. (Further details to be added if this service is explored).
    -   To run: `cd springBoot-rabbitmq-consumer && mvn spring-boot:run`
-   **`springBoot-restapi-crud`**: Provides a RESTful API for CRUD operations, interacting with a MongoDB database. Uses Spring Boot 2.1.0.RELEASE and Java 8.
    -   To run: `cd springBoot-restapi-crud && mvn spring-boot:run`
-   **`springBoot-security`**: A Spring Boot application focused on security configurations, potentially related to OAuth2. Uses Spring Boot 2.1.0.RELEASE, Java 8, and includes `spring-security-oauth2`.
    -   To run: `cd springBoot-security && mvn spring-boot:run`



Instructions for running these services individually will be added here. Typically, they can be run using:
```bash
mvn spring-boot:run
```
from their respective directories.

## Development

(Details about setting up development environments, coding standards, etc., can be added here.)

## Bug Reporting and Feature Requests

(Information on how to report bugs or request features.)

## CI/CD

A CI/CD pipeline is set up using GitHub Actions. (More details once implemented)
