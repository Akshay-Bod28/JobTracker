Job Tracker Application:

A full-stack job application tracking system built with Spring Boot and JWT authentication, demonstrating modern backend development practices and security implementation.

Project Overview:

This application provides a secure REST API for tracking job applications with user authentication and authorization. Built from scratch to showcase understanding of enterprise-level backend architecture, security principles, and database management.

LinkedIn: https://www.linkedin.com/in/akshay-bodanapu/

Key Skills Demonstrated:

Backend Development

- RESTful API design and implementation
- Spring Boot 3.x framework proficiency
- Dependency Injection and Inversion of Control (IoC)
- Service-oriented architecture (Controller → Service → Repository pattern)
- Exception handling and error management

Security & Authentication

- JWT (JSON Web Token) authentication from scratch
- Spring Security 6.x configuration
- Password hashing with BCrypt
- Stateless session management
- Role-based access control preparation

Database Management

- JPA/Hibernate ORM
- Repository pattern implementation
- Entity relationships and modeling
- Database schema design

Software Engineering Practices

- Clean code architecture
- SOLID principles
- Git version control
- API documentation
- Project structure and organization


Architecture & Design:

Three-Layer Architecture:
Layer 1: Presentation Layer
- Controllers - HTTP Endpoints
Layer 2: Business Logic Layer
- Services - Core Application Logic
Layer 3: Data Access Layer
- Repositories - Database Operations

Security Flow:

Client Request -> Spring Security Filter Chain -> JWT Validation (for protected endpoints)
-> Controller -> Service -> Repository -> Response with JWT token (auth endpoints)

Tech Stack:

Framework: Spring Boot 3
Security: Spring Security 6
Authentication: JWT (JSON Web Tokens)
Database: JPA/Hibernate + PostgreSQL
Password Hashing: BCrypt
Build Tool: Maven
Language: Java

Project Structure: 

job-tracker/
├── src/main/java/com/yourName/job_tracker/
│   ├── controller/
│   │   └── AuthController.java          # Authentication endpoints
│   ├── service/
│   │   └── AuthService.java             # Business logic for auth
│   ├── repository/
│   │   └── UserRepository.java          # Database access layer
│   ├── model/
│   │   └── User.java                    # User entity with UserDetails
│   ├── dto/
│   │   ├── RegisterRequest.java         # Registration data transfer
│   │   ├── LoginRequest.java            # Login data transfer
│   │   └── AuthResponse.java            # JWT response wrapper
│   ├── security/
│   │   ├── JwtUtil.java                 # JWT token generation/validation
│   │   └── SecurityConfig.java          # Spring Security configuration
│   ├── exception/
│   │   └── BadRequestException.java     # Custom exception handling
│   └── JobTrackerApplication.java       # Application entry point
└── src/main/resources/
    └── application.properties            # Configuration

Security Implementation:

- JWT Authentication
- Implemented stateless JWT authentication demonstrating understanding of:

- Token generation with claims (username, issued date, expiration)
- HMAC-SHA256 signature verification
- Token validation and extraction
- Stateless session management (no server-side session storage)

Why JWT?

- Scalable (no server-side session storage)
- Secure (signed tokens prevent tampering)
- Stateless (perfect for REST APIs and microservices)
- Industry-standard authentication method

Password Security

- BCrypt hashing with automatic salting
- One-way encryption (passwords cannot be reversed)
- Unique salt per password (prevents rainbow table attacks)
- Configurable work factor for future-proofing

Spring Security Configuration

- CSRF disabled (correct for stateless REST APIs)
- Public endpoints (/api/auth/**) for registration/login
- Protected endpoints require valid JWT
- Stateless session management
- BCryptPasswordEncoder for password hashing

Technical Decisions & Rationale:

Why Spring Boot?

- Industry-standard enterprise framework
- Built-in dependency injection
- Auto-configuration reduces boilerplate
- Large ecosystem and community support

Why JWT over Session-based Auth?

- Scalability: No server-side session storage needed
- Stateless: Perfect for REST APIs and microservices
- Mobile-friendly: Easy token storage on mobile apps
- Horizontal scaling: No session replication needed

Why BCrypt over other hashing algorithms?

- Adaptive: Can increase work factor as computers get faster
- Built-in salting: Automatic unique salt per password
- Proven security: Industry standard, battle-tested
- Slow by design: Makes brute-force attacks impractical

Why Three-Layer Architecture?

- Separation of concerns: Each layer has one responsibility
- Testability: Easy to unit test business logic
- Maintainability: Changes in one layer don't affect others
- Scalability: Can swap implementations without affecting other layers


Development Process: 

Built Without any prior experience/knowledge of:
- Spring Framework or Spring Boot
- Authentication and security concepts
- JWT tokens
- Spring Security
- JPA/Hibernate

Learning Approach:

- Researched core concepts before implementation
- Understood why each component exists, not just how to implement
- Made architectural decisions based on best practices
- Focused on clean, maintainable code over quick solutions

Key Learning Achievements

- Dependency Injection: Deep understanding of IoC containers and why they matter
- Security Principles: Learned CSRF, JWT, stateless auth, password hashing
- Filter Chains: How Spring Security processes requests
- ORM Concepts: Mapping objects to database tables with JPA


Current Status & Roadmap:

Completed:

- User registration with password hashing
- User login with JWT generation
- Spring Security configuration
- JWT utility methods (generate, validate, extract)
- Three-layer architecture setup
- Exception handling
- Database entity modeling

In Progress:

- JWT Authentication Filter (token validation on protected endpoints)
- Job application CRUD endpoints
- User profile management

Planned Features:

-Job application tracking (create, update, delete, view)
- Application status workflow (Applied → Interview → Offer → Accepted/Rejected)
- Search and filter functionality
- User dashboard with statistics
- Email notifications
- Role-based authorization (Admin/User)
- API documentation with Swagger
- Unit and integration tests
- Docker containerization
- CI/CD pipeline

What This Project Demonstrates:

- Ability to learn complex frameworks independently
- Understanding of software architecture principles
- Security-conscious development practices
- Clean, maintainable code structure
- Problem-solving and research skills

- Backend: Spring Boot, REST APIs, JPA
- Security: JWT, Spring Security, BCrypt
- Database: ORM, entity modeling
- Architecture: Three-layer pattern, dependency injection
- Tools: Maven, Git, VS Code

Setup & Installation:

Prerequisites:

- Java 17 or higher
- Maven 3.6+
- PostgreSQL/pgAdmin
- Git

Local Development Setup:

# Clone the repository
git clone https://github.com/Akshay-Bod28/JobTracker.git
cd JobTracker

# Configure database connection
# Edit src/main/resources/application.properties with your database credentials

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# Application will start on http://localhost:8080
Testing with Postman/cURL
Register a new user:

bashcurl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "email": "test@example.com",
    "password": "password123"
  }'

Login:

bashcurl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'

📞 Contact & Links
Developer: Akshay Bodanapu
GitHub: @Akshay-Bod28
LinkedIn: https://www.linkedin.com/in/akshay-bodanapu/
Email: akshaybod28@gmail.com

Last Updated: November 14 2025
