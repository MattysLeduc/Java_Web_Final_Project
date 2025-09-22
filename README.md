# Java Web Final Project

## 📚 What is this Project?

This project is a full-stack application composed of:

- **Backend**: a Spring Boot REST API (Java) for managing recipes, ingredients, instructions.
- **Frontend**: a React + TypeScript client that consumes the backend API.

It demonstrates:
- RESTful services with Spring Boot
- JPA/Hibernate persistence
- Switching between MySQL and H2
- Client‑server architecture with HTTP + JSON

---

## 🚀 Tech Stack

| Layer | Tech / Tools |
|---|---|
| Backend | Java, Spring Boot, Spring Data JPA, Hibernate |
| Database | MySQL (prod), H2 (dev/test) |
| Frontend | React, TypeScript, Axios |
| Build | Maven (backend), npm/yarn (frontend) |

---

## 🛠️ Setup & Running

### Prerequisites
- Java 17+
- Maven
- Node.js + npm or yarn
- MySQL (optional)

### Backend

1. Clone the repo:
   ```bash
   git clone https://github.com/MattysLeduc/Web-Services_Final-Project.git
   cd Web-Services_Final-Project/recipe-app-backend
   ```

2. Database choice:
   - **H2 (default/dev)**:
     ```
     spring.datasource.url=jdbc:h2:mem:ems;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
     spring.jpa.hibernate.ddl-auto=update
     spring.h2.console.enabled=true
     spring.h2.console.path=/h2-console
     ```
   - **MySQL**:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/ems
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Build & Run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. H2 Console:
   - Visit: http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:ems
   - User: sa
   - Pass: (blank)

### Frontend

1. Open new terminal:
   ```bash
   cd library-app-frontend
   ```

2. Install deps:
   ```bash
   npm install
   ```

3. Run:
   ```bash
   npm start
   ```

---

## 🔧 Troubleshooting

- **Column mismatches**: Ensure consistent naming (`recipe_id` vs `recipeId`).
- **Script errors**: `data.sql` must use correct column names.
- **Port conflicts**: Adjust backend or frontend config.
- **CORS**: Allow requests from frontend (localhost:3000).

---

## 📦 Repo Structure

- `recipe-app-backend/` — Spring Boot backend
  - Entities: Recipe, Ingredients, Instructions
  - Controllers, Repositories, Services
  - `schema.sql`, `data.sql`
- `library-app-frontend/` — React frontend
  - Components for recipes
  - Axios client
  - Pages for listing recipes

---

## ✅ Summary

This is a web app for managing recipes. It uses Spring Boot for the backend and React for the frontend, with MySQL or H2 as the database.
