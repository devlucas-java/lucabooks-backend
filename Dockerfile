
LABEL authors="devlucas-java"
LABEL description="Dockerfile for lucabooks application"
LABEL version="1.0"

FROM maven:3.9.9-eclipse-temurin-21 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean install -DskipTests

FROM openjdk:21-jdk

COPY --from=build /app/target/lucabooks-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080