# Use OpenJDK 21 slim base image
FROM openjdk:21-slim AS build

# Install Maven from the official repositories
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Verify Maven installation
RUN mvn -version

# Rest of the Dockerfile (copy, build, etc.)
WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]