# 1. Task Management System 

**Description:**  
Create a web application to manage tasks, allowing users to create, view, update, and delete tasks. The application should include user login and registration functionalities to ensure that tasks are securely managed by authenticated users.  API RESTful,


# Guidelines for Creating a RESTful API

To create a RESTful API, which is an API that follows the REST (Representational State Transfer) principles, it is important to adhere to certain conventions and best practices. Below are the essential standards a RESTful API should follow:

## Proper Use of HTTP Verbs:

- **GET**: Retrieve resources.
  
 ![image](https://github.com/user-attachments/assets/7134de66-38ed-4767-a0b1-0e1ab3520d50)

  
- **POST**: Create new resources.

  ![image](https://github.com/user-attachments/assets/763598df-87c8-495c-87cd-1bb6d1b192eb)

- **PUT**: Fully update existing resources.

  ![image](https://github.com/user-attachments/assets/39004a61-e858-428b-b8ed-30e0d8fcef6f)

- **PATCH**: Partially update an existing resource.
- **DELETE**: Delete resources.

  ![image](https://github.com/user-attachments/assets/f3942b3b-937a-41bb-816c-01903152cc43)


## Consistent and Meaningful URI Addresses:

- Use nouns, not verbs, in URIs to represent resources (e.g., `/users` to access users).
- URIs should be organized to reflect hierarchical relationships (e.g., `/users/123/posts` for posts from a specific user).

```bash
curl -X POST "http://localhost:8080/tasks/add" \
     -H "Content-Type: application/json" \
     -H "Accept: application/json" \
     -d '{"title": "Nova Tarefa", "description": "Descrição da tarefa", "status": "PENDENTE"}'
```

```bash
curl -X PUT "http://localhost:8080/tasks/1/done" \
     -H "Accept: application/json"
```

## Appropriate Use of HTTP Status Codes:

- **200 OK**: The request was successful.
- **201 Created**: A new resource was successfully created.
- **204 No Content**: The request was successful, but there is no content to return.
- **400 Bad Request**: The request was not processed due to client error.
- **404 Not Found**: The requested resource was not found.
- **500 Internal Server Error**: General error when the server fails to process the request.

## Resource Representation:

- Provide resource representations in formats such as JSON or XML.
- Use HTTP headers to negotiate content (Content Negotiation) via the `Accept` field in the request header.

## Statelessness:

- Each request should contain all the information necessary for the server to understand and process it without requiring stored session state on the client.

## Cacheability:

- Allow responses to be cacheable when appropriate to improve efficiency. Use HTTP headers to control caching, such as `Cache-Control`.

![image](https://github.com/user-attachments/assets/859f1a4d-cbb3-4c6c-baa9-6070eb9f6ddb)



## Use of HATEOAS (Hypermedia As The Engine Of Application State):

- Include links in resource representations to guide clients in navigating and discovering the API’s functionalities.

## Security:

- Implement appropriate authentication and authorization, such as OAuth or API tokens.
- Use HTTPS to ensure secure transmission of data.

## Documentation:

- Provide clear and complete documentation for developers who will consume your API, including request and response examples, parameter descriptions, error codes, etc.


### Spring Boot Framework
- **Spring Boot**: A framework for building Java applications quickly, with minimal configuration. It simplifies the development of production-ready applications.
- **Spring MVC**: A component of the Spring Framework used to build web applications. It follows the Model-View-Controller (MVC) design pattern.
- **Spring Data JPA**: Provides a convenient way to interact with relational databases using Java Persistence API (JPA). It simplifies database operations like CRUD (Create, Read, Update, Delete).
- **Spring Security**: A powerful security framework that provides authentication, authorization, and protection against common security threats.
- **Thymeleaf**: A server-side Java template engine for web applications. It allows for natural templating, meaning HTML files can be opened in a browser without a running application.
- **REST APIs**: Representational State Transfer (REST) APIs provide a way to interact with the backend services, following REST principles.
- **H2 Database** or **MySQL**: Use an in-memory database like H2 for development and testing or MySQL for production to persist application data.
- **Testing with JUnit and Mockito**: Ensure the quality of your application by writing unit tests using JUnit, and mock dependencies using Mockito to isolate units of code during testing.
