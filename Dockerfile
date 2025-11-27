# Build stage
# Etapa 1: Build da aplicação usando Maven + JDK 17
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

COPY Desafio-Preco-Justo/pom.xml .

RUN mvn dependency:go-offline -B

COPY Desafio-Preco-Justo/src ./src

RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
