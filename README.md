# WealthCore API:

Backend API for managing investment portfolios, built with Java & Spring Boot using Hexagonal Architecture principles.

# Features

* Portfolio management (create, update, delete, retrieve)

* Investment management within portfolios

* Portfolio performance calculation (benefit & return percentage)

* Consolidated reporting endpoint

* JWT-based security

* In-memory database for development & tests (H2)

# Architecture

Hexagonal (Ports & Adapters) architecture with clear separation between:

* Domain (business models & rules)

* Application (use cases)

* Infrastructure (REST controllers, persistence)

* Configuration (security)

# Tech Stack

* Java 21

* Spring Boot 3

* Spring Data JPA

* Spring Security

* H2 Database

* Maven

* JUnit 5

# Endpoints

* /api/portfolios

* /api/portfolios/{id}

* /api/portfolios/{id}/investments

* /api/investments/{id}

* /api/portfolios/{id}/performance

* /api/portfolios/{id}/report