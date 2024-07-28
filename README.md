# Basic Intranet Template

## Overview
MVP version is ready. Following goals: 
- add sorting and filters
- enrich with exceptions' handling
- fix small bugs

Basic intranet service with the most popular CRUD functions for it. Also, security with JWT is added.
Flyway will create ADMIN user with password "adminpass" encrypted by BCrypt.

Stack: Java 17, Spring Boot, Spring Web, Spring JPA, Spring Security, JWT, Flyway, PostgreSQL, Swagger
