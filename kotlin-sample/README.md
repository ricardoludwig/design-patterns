# Kotlin 

## Requirements

- Maven 3.6
- Java 21
- Kotlin

## Documentação

not implemented

## Uso

### Execução

``mvn package``

``java -jar kotlin-console-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar``

### Tests

* ``mvn test``: Roda somente os testes unitários
* ``mvn failsafe:integration-test``: Roda somente os testes de integração
* ``mvn integration-test``: Roda os testes unitários e de integração

### Sonar

Para rodar a task do sonar é preciso exportar as variáveis de ambiente `SONAR_URL` e
`SONAR_TOKEN`.

No bash a exportação de variáveis é feita da seguinte forma:

export SONAR_URL = __URL_DO_SONAR__ 
export SONAR_TOKEN = __TOKEN_DO_SONAR__

Depois basta rodar o comando.

`` mvn -Psonar -Dsonar.projectKey=ricardoludwig.service:template-kotlin verify sonar:sonar``

