# 1. Task Management System

**Description:**  
Create a web application to manage tasks, allowing users to create, view, update, and delete tasks. The application should include user login and registration functionalities to ensure that tasks are securely managed by authenticated users.

**Study/Practice Topics:**

### RESTful Principles
- **Client-Server**: Separation of concerns between the client (user interface) and server (backend services), enabling independent development and scaling.
- **Stateless**: Each request from the client to the server must contain all the information the server needs to fulfill the request, without relying on stored context on the server.
- **Cacheability**: Responses from the server must be explicitly marked as cacheable or non-cacheable to improve performance by reducing the need for repeated requests.
- **Uniform Interface**: A standardized interface between the client and server, consisting of:
  - **Resource Identification**: Resources are identified through URIs.
  - **Representations**: Resources can have multiple representations (e.g., JSON, XML).
  - **Self-descriptive Messages**: Each message includes enough information to describe how it should be processed.
  - **HATEOAS (Hypermedia As The Engine Of Application State)**: Clients interact with the application entirely through hypermedia provided dynamically by the server.

### Spring Boot Framework
- **Spring Boot**: A framework for building Java applications quickly, with minimal configuration. It simplifies the development of production-ready applications.
- **Spring MVC**: A component of the Spring Framework used to build web applications. It follows the Model-View-Controller (MVC) design pattern.
- **Spring Data JPA**: Provides a convenient way to interact with relational databases using Java Persistence API (JPA). It simplifies database operations like CRUD (Create, Read, Update, Delete).
- **Spring Security**: A powerful security framework that provides authentication, authorization, and protection against common security threats.
- **Thymeleaf**: A server-side Java template engine for web applications. It allows for natural templating, meaning HTML files can be opened in a browser without a running application.
- **REST APIs**: Representational State Transfer (REST) APIs provide a way to interact with the backend services, following REST principles.
- **H2 Database** or **MySQL**: Use an in-memory database like H2 for development and testing or MySQL for production to persist application data.
- **Testing with JUnit and Mockito**: Ensure the quality of your application by writing unit tests using JUnit, and mock dependencies using Mockito to isolate units of code during testing.
