#  Personal Expense Controller

A backend application built with **Spring Boot** to manage personal expenses and categories with a clean layered architecture, Swagger API documentation, exception handling, and full CRUD operations.

---

## 📁 Project Structure

```
expense-tracker-app
├── controller
│   ├── CategoryController.java
│   └── ExpanseController.java
├── dto
│   ├── CategoryDto.java
│   └── ExpanseDto.java
├── entity
│   ├── Category.java
│   └── Expanse.java
├── exception
│   ├── ErrorDetails.java
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── mapper
│   ├── CategoryMapper.java
│   └── ExpanseMapper.java
├── repository
│   ├── CategoryRepository.java
│   └── ExpanseRepository.java
├── service
│   ├── impl
│   │   ├── CategoryServiceImpl.java
│   │   └── ExpanseServiceImpl.java
│   ├── CategoryService.java
│   └── ExpanseService.java
└── ExpanseTrackerAppApplication.java
```

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Swagger (OpenAPI 3)**
- **Postman** (for testing)

---

##  Features

- 🔹 Add, update, delete, and fetch **Categories**
- 🔹 Add, update, delete, and fetch **Expenses**
- 🔹 Search expense by **category**
- 🔹 Filter by **date** or **amount**
- 🔹 Global Exception Handling
- 🔹 Swagger-based API Documentation

---

## 🔗 API Endpoints

### ✅ Category API

| Method | Endpoint                        | Description              |
|--------|----------------------------------|--------------------------|
| POST   | `/api/category/post`            | Create a new category    |
| GET    | `/api/category/get/{id}`        | Get category by ID       |
| GET    | `/api/category/getAll`          | Get all categories       |
| PUT    | `/api/category/update/{id}`     | Update category          |
| DELETE | `/api/category/delete/{id}`     | Delete category          |

---

### ✅ Expense API

| Method | Endpoint                         | Description               |
|--------|----------------------------------|---------------------------|
| POST   | `/api/expanse/post`             | Create a new expense      |
| GET    | `/api/expanse/get/{id}`         | Get expense by ID         |
| GET    | `/api/expanse/getAll`           | Get all expenses          |
| PUT    | `/api/expanse/update/{id}`      | Update expense            |
| DELETE | `/api/expanse/delete/{id}`      | Delete expense            |

---

## 🔍 API Testing

Use **Postman** or directly access Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/expense-tracker-app.git
   cd expense-tracker-app
   ```

2. Configure `application.properties` with your MySQL credentials.

3. Run the app from your IDE or use:
   ```bash
   ./mvnw spring-boot:run
   ```

---

##  Author

**Ritik** — Backend Developer | Java | Spring Boot | API Enthusiast  
_If you like the project, drop a ⭐ on GitHub!_