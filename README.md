# CodeArena — CI/CD Pipeline for Java Application

## Project Overview
A Spring Boot Quiz Application with a complete CI/CD pipeline using Jenkins and Docker.

## Tech Stack
- Backend: Spring Boot 3.3.5
- Language: Java 21
- Build Tool: Maven
- Database: MySQL 8.0
- Containerization: Docker
- CI/CD: Jenkins
- Version Control: Git & GitHub

## Pipeline Flow
Push Code to GitHub → Webhook → Jenkins → Maven Build → JUnit Tests → Docker Image → Docker Hub → Deploy

## API Endpoints
- POST /api/auth/register — Register user
- POST /api/auth/login — Login user
- POST /api/quiz/create — Create quiz
- GET  /api/quiz/all — Get all quizzes
- GET  /api/quiz/{id} — Get quiz by ID
- POST /api/quiz/attempt — Attempt quiz
- GET  /api/quiz/leaderboard/{id} — Get leaderboard

## Run Locally
mvn spring-boot:run

## Run with Docker
docker-compose up -d

## Run Tests
mvn test

## Project Outcomes
1. Automated Builds - Maven compiles on every push
2. Docker Integration - App runs in containers
3. Continuous Delivery - Auto deploy after every successful build
# CodeArena Quiz App
Webhook test Sat Jul 11 02:30:30 IST 2026
