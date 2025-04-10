# Etapa de build com Gradle 7.6 e JDK 17
FROM gradle:7.6-jdk17 AS builder

WORKDIR /app
COPY . .

# Faz o build do projeto sem precisar de daemon
RUN gradle build --no-daemon

# Etapa de execução com JDK 17 slim (mais leve)
FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
