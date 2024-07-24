# Customer Management API

Customer Management API is a Java project developed with Spring Boot for managing customers. It includes basic functionalities for creating, reading, updating, and deleting customer information.

## Requirements

- **Java**: 17 (BellSoft LibericaJDK-17)
- **Maven**: 3.9.8

## Installation

### Clone the repository

```
git clone https://github.com/andrescanm/customer_management_api.git
cd customer_management_api
```
### Build and Run
```
- ./mvnw clean install
- ./mvnw spring-boot:run
```
### Lombok
This project uses Lombok to reduce boilerplate code. Lombok annotations are used for generating getters, setters, constructors, and other common methods automatically. To ensure that Lombok works correctly in your IDE, you might need to install a Lombok plugin and enable annotation processing.
## API Documentation

The API documentation is available through Swagger. Once the application is running, you can access the documentation at the following URL:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Database Configuration

The project is configured to use an in-memory H2 database for development and testing purposes. The H2 console can be accessed at the following URL:

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User Name**: `sa`
- **Password**: password

## Project Structure

- **src/main/java**: Application source code.
    - **com.accelone.customer_management_api**: Main package.
        - **config**: Application configurations (e.g., SwaggerConfig).
        - **controller**: REST API controllers.
        - **model**: Model classes and JPA entities.
        - **repository**: JPA repository interfaces.
        - **service**: Service classes and business logic.
- **src/main/resources**: Application resources.
    - **dbtest**: Database schema and data files for H2.
    - **application.properties**: Application configuration properties.
## Code Coverage with JaCoCo

The project uses JaCoCo to measure code coverage for unit tests. To generate the code coverage report, follow these steps:

1. **Run the tests and generate the report:**

    ```bash
    ./mvnw clean test
    ```

2. **View the JaCoCo report:**

   After running the tests, the JaCoCo report will be generated in the `target/site/jacoco` directory. Open the `index.html` file in a web browser to view the coverage report:

    ```bash
    open target/site/jacoco/index.html
    ```
---
#### 2024 - andrescanm