# Build stage
# Includes JDK + Maven to compile and package the app inside container build.
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /workspace
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY src src
RUN chmod +x mvnw && ./mvnw -q -DskipTests package

# Runtime stage
# Uses a lighter JRE image; JDK is only needed in build stage above.
FROM eclipse-temurin:17-jre
WORKDIR /app
RUN useradd -r -u 1001 appuser
COPY --from=builder /workspace/target/backend-demo-app.jar app.jar
EXPOSE 9090
USER appuser
ENTRYPOINT ["java", "-Dspring.profiles.active=k8s", "-jar", "app.jar"]
