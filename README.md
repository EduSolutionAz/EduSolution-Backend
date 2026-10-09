# ESAcademy Backend

A Spring Boot backend for the ESAcademy education platform, designed to support university discovery, applicant engagement, secure authentication, and operational administration for study-abroad services.

## Overview

ESAcademy provides a robust API layer for managing:

- Universities, faculties, and academic programs
- Countries and country-specific educational data
- Applicant comments, requests, and review workflows
- Client registration, verification, and authentication
- Admin access and platform operations
- Promotional ads and website property content
- Spin-based prize interactions and engagement campaigns
- Email notifications and cloud media storage

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Security + JWT
- Spring Data JPA + PostgreSQL
- Liquibase for schema migrations
- Springdoc OpenAPI / Swagger UI
- AWS S3-compatible storage integration
- Resend email service
- Maven
- Docker / Docker Compose

## Project Structure

```text
.
├── src/main/java/com/edu/edusolution/   # Application source code
│   ├── config/                          # Security, JWT, Swagger, AWS config
│   ├── controller/                      # REST API endpoints
│   ├── dto/                             # Request/response contracts
│   ├── entity/                          # JPA entities
│   ├── repository/                      # Data access layer
│   ├── service/                         # Business logic
│   ├── exception/                       # Exception handling
│   └── constants/                       # Shared constants
├── src/main/resources/                  # Application config and Liquibase scripts
├── Dockerfile                           # Container build definition
├── docker-compose.yaml                  # Local PostgreSQL + app services
├── pom.xml                              # Maven build configuration
├── mvnw                                 # Maven wrapper
├── .env                                 # Local environment variables
└── README.md                            # Project overview
```

## Getting Started

### Prerequisites

- Java 21+
- Maven or the included Maven wrapper
- PostgreSQL
- Docker (optional, for local containerized setup)

### Run with Docker

```bash
docker-compose up --build
```

### Run locally

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application will start on the default port defined in the project configuration, typically:

- http://localhost:8080

Swagger UI is available at:

- http://localhost:8080/swagger-ui/index.html

## Environment Configuration

The application expects configuration values for database access, JWT secrets, AWS storage, and email delivery. These can be provided through environment variables or a local `.env` file.

Key configuration areas include:

- PostgreSQL datasource connection
- JWT secret and expiration settings
- AWS S3 / Cloudflare R2 credentials
- Admin credentials
- Resend email API settings

## Core Modules

- Authentication and user management
- Country and university catalog APIs
- Applicant and contact management
- Ad and web-property publishing
- Spin-game prize and winner logic
- Admin dashboard support

## License

This project is intended for internal product development and educational platform operations. Please consult the repository owner for licensing and usage terms.
