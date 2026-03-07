# Spring Boot + MySQL Kubernetes Deployment

Production-style sample for deploying a Spring Boot backend with MySQL using Docker and Kubernetes.

## Stack
- Java 17, Spring Boot
- Spring Data JPA, Validation, Actuator
- MySQL
- Docker, Docker Compose, Kubernetes

Learning-focused comments in source are intentionally preserved.

## Project Structure
- `backend-demo-app/`: Spring Boot service
- `backend-demo-app/kubernetes-deployments/`: Kubernetes manifests

## Local Run (Docker Compose)
```bash
cd backend-demo-app
docker compose up --build
```

API base URL: `http://localhost:9090/api/v1`

## Kubernetes Deploy
Apply manifests in this order:

```bash
kubectl apply -f backend-demo-app/kubernetes-deployments/backend-demo-secret.yaml
kubectl apply -f backend-demo-app/kubernetes-deployments/backend-demo-configmap.yaml
kubectl apply -f backend-demo-app/kubernetes-deployments/mysql-deployment.yaml
kubectl apply -f backend-demo-app/kubernetes-deployments/mysql-service.yaml
kubectl apply -f backend-demo-app/kubernetes-deployments/backend-demo-app-deployment.yaml
kubectl apply -f backend-demo-app/kubernetes-deployments/backend-demo-app-service.yaml
```

## Health Endpoints
- `/actuator/health`
- `/actuator/health/liveness`
- `/actuator/health/readiness`

## Test
```bash
cd backend-demo-app
./mvnw test
```
