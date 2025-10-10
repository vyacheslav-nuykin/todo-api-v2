# 🌿 Simple Todo API

A RESTful Todo List API built with **Spring Boot**.  
My first step towards becoming a backend engineer and move to Norway 🇳🇴

## ✨ Features

- Create, read, update (complete), delete todos
- In-memory storage (no database required)
- Full CRUD operations
- Proper HTTP status codes and error handling

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven

### Run the application
```bash
./mvnw spring-boot:run
```

### API Endpoints

| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| GET    | `/api/todo`            | Get all todos                   |
| POST   | `/api/todo`            | Create a new todo               |
| GET    | `/api/todo/{id}`       | Get todo by ID                  |
| PATCH  | `/api/todo/{id}/complete` | Mark todo as completed       |
| DELETE | `/api/todo/{id}`       | Delete todo by ID               |

### Example: Create a todo
```bash
curl -X POST http://localhost:8080/api/todo \
  -H "Content-Type: application/json" \
  -d '{"title":"Learn Java for Norway"}'
```

## 🛠️ Built With
- Java 17
- Spring Boot 3.5.6
- Maven

## 💚 Author
Vyacheslav Nuykin — [GitHub](https://github.com/vyacheslav-nuykin)  
*Building my future, one line of code at a time.*
