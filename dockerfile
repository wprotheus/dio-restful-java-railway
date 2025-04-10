FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/dio-restful-java-railway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]