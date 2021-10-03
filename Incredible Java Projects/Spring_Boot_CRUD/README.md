# SpringBoot-CRUD-Example
Spring Boot CRUD demo is demonstrating how to implement simple CRUD operations with a Student entity.

## What's Inside
- Maven
- Spring Core
- Spring Rest
- Spring Data JPA (Hibernate & Oracle)

## Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database Configuration
Create a Oracle database with the name system and add the credentials to /resources/application.properties.
The default ones are :

```
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=system
spring.datasource.password=system

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle10gDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

## Usage
Run the project through the IDE and head out to [Postman](https://www.postman.com/downloads/) and enter the following url [http://localhost:8080](http://localhost:8080)
