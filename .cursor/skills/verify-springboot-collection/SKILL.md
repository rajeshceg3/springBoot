---
name: verify-springboot-collection
description: Verifies the Spring Boot Microservices Collection - packages all ten subprojects and runs the infra-free test suites - with machine-readable evidence.
---

# Verify Spring Boot Microservices Collection

## Launch

```bash
# JDK 11 (or 17) and Maven required
python3 .cursor/skills/verify-springboot-collection/verify.py
```

Exit 0 and `FAILURES=0` mean green. No Docker, Kafka, RabbitMQ, MongoDB,
or OAuth provider is needed: every check is infra-free.

## Doctor

Gates on a JDK and `mvn` being available. Java 11 matches the
subprojects' toolchains; JDK 17 also packages cleanly.

## Drive

1. `mvn -B -q -DskipTests package` for each of the ten subprojects:
   springBoot-jwt, kafka-consumer, kafka-producer, oauth,
   rabbitmq-consumer, rabbitmq-producer, restapi-crud, security,
   docker-compose/user-service, docker-compose/bank-service.
2. `mvn -B test` for the two subprojects with real infra-free suites:
   - springBoot-jwt: context load of the H2-backed JPA/security app.
   - springBoot-restapi-crud: MovieController WebMvcTest suite.

## Evidence

Each run writes a fresh `EVIDENCE_DIR` with `evidence.json`.
`FAILURES=n` is the last line; the exit code mirrors it.

## Maintenance

When a subproject gains an infra-free test suite, add it to TESTED in
the runner in the same commit.

## Known boundaries

- Boot smokes are out of scope: kafka/rabbitmq/oauth/mongodb-backed
  services need their brokers and providers, and the docker-compose
  pair needs Docker. Packaging plus the infra-free suites is the
  honest, runnable proof in this environment.
- springBoot-kafka-* , springBoot-rabbitmq-*, springBoot-oauth, and
  springBoot-security have no tests; they are proven by packaging only.
