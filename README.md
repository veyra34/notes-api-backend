# Project Overview

Minimal backend for a Notes Management application. Provides user register/login and notes CRUD. Project is in active development.

## Features

- User register and login APIs
- Create, read, update, delete notes
- JPA entity relationships between users and notes
- Layered architecture: Controller, Service, Repository, Entity

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven (wrapper included)

## API Endpoints

User APIs

| Method | Endpoint | Description |
| ------ | -------- | ----------- |
| POST | /users/register | Register a new user |
| POST | /users/login | Authenticate a user |

Notes APIs

| Method | Endpoint | Description |
| ------ | -------- | ----------- |
| POST | /notes/create/{userId} | Create a note for the specified user |
| GET  | /notes/all/{userId} | List all notes for the specified user |
| GET  | /notes/{id}/{userId} | Get a specific note by id for the specified user |
| PUT  | /notes/update/{id}/{userId} | Update a note (requires userId) |
| PUT  | /notes/delete/{id}/{userId} | Delete a note (implemented as PUT in controller) |

All endpoints use JSON request and response bodies.

## Project Structure

- `src/main/java/com/example/Notes/`
  - `controller/`
  - `service/`
  - `repository/`
  - `entity/`
- `src/main/resources/application.properties`

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/veyra34/notes-api-backend.git
cd Notes
```

2. Update `src/main/resources/application.properties` with your PostgreSQL settings:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/notesdb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Run with Maven wrapper (Windows):

```powershell
.\mvnw.cmd clean package
.\mvnw.cmd spring-boot:run
```

Or build and run the jar:

```powershell
.\mvnw.cmd clean package
java -jar target/Notes-0.0.1-SNAPSHOT.jar
```

## Future Improvements

- JWT authentication & authorization
- DTO layer for requests/responses
- Validation (`@Valid`) and custom validators
- Centralized exception handling (ControllerAdvice)
- Frontend integration and API documentation (OpenAPI/Swagger)

