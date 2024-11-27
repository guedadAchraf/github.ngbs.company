# Stage 1: Build
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Set working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-jammy

# Set working directory in the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=builder /app/target/ngbs-app-backend-*.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
