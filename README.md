# 🌿 Todo API (Enterprise Edition)

A **production-ready RESTful Todo List API** built with **Spring Boot 3**, **PostgreSQL**, and clean enterprise architecture.  
This is a complete rewrite of my [first Todo API](https://github.com/vyacheslav-nuykin/todo-api) — now with real database, validation, security-ready design, and full documentation.

> *"Building my future, one line of code at a time."*  
> — Vyacheslav Nuykin | Future Java Developer in Norway 🇳🇴

---

## ✨ Features

- ✅ Full CRUD operations (Create, Read, Update, Delete)
- ✅ **PostgreSQL** persistence (no in-memory hacks)
- ✅ Input validation with `@Valid` and `@NotBlank`
- ✅ Proper HTTP responses: `201 Created`, `204 No Content`, `404 Not Found`, `400 Bad Request`
- ✅ **Swagger UI** for interactive API documentation (`/swagger-ui.html`)
- ✅ **Actuator** endpoints for health monitoring (`/actuator/health`)
- ✅ Clean layered architecture: Controller → Service → Repository → DTO
- ✅ Immutable DTOs (`TodoResponse`, `TodoCreateRequest`)
- ✅ Business-specific endpoints (e.g., `PATCH /api/todo/{id}/complete`)
- ✅ Ready for Spring Security (just add auth!)

---

## 🚀 Getting Started

### Prerequisites
- **Java 17+**
- **Maven**
- **PostgreSQL** (running locally or in Docker)

### 1. Set up PostgreSQL
Create a database and user:
```sql
CREATE DATABASE devdb;
CREATE USER devuser WITH PASSWORD 'devpass';
GRANT ALL PRIVILEGES ON DATABASE devdb TO devuser;
```

Or use Docker:
```bash
docker run -d --name todo-db \
  -e POSTGRES_DB=devdb \
  -e POSTGRES_USER=devuser \
  -e POSTGRES_PASSWORD=devpass \
  -p 5432:5432 \
  postgres:16-alpine
```

### 2. Run the application
```bash
./mvnw spring-boot:run
```

The app will connect to PostgreSQL and auto-create the `todos` table.

---

## 📡 API Endpoints

| Method | Endpoint                     | Description                     |
|--------|------------------------------|---------------------------------|
| `GET`    | `/api/todo`                  | Get all todos                   |
| `POST`   | `/api/todo`                  | Create a new todo               |
| `GET`    | `/api/todo/{id}`             | Get todo by ID                  |
| `PATCH`  | `/api/todo/{id}/complete`    | Mark todo as completed          |
| `DELETE` | `/api/todo/{id}`             | Delete todo by ID               |

### Example: Create a todo
```bash
curl -X POST http://localhost:8080/api/todo \
  -H "Content-Type: application/json" \
  -d '{"title":"Learn Spring Boot for Norway"}'
```

---

## 📚 Documentation

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
  → Explore and test all endpoints interactively.

- **Actuator Health**: [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)  
  → Monitor application status.

---

## 🛠️ Built With

- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Web**, **Spring Data JPA**, **Hibernate**
- **PostgreSQL**
- **Lombok**
- **Jakarta Validation**
- **SpringDoc OpenAPI** (Swagger)
- **Spring Boot Actuator**

---

## 💚 Author

**Vyacheslav Nuykin**  
📧 nujkinvaceslav@gmail.com  
🔗 [GitHub](https://github.com/vyacheslav-nuykin)  
📍 Chelyabinsk, Russia → **Future: Oslo, Norway**

> *Preparing for a career in Norway’s IT industry — one clean, production-ready project at a time.*