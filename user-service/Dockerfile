FROM eclipse-temurin:21-jdk

WORKDIR /app

# Копируем билдованный jar в контейнер
COPY build/libs/user-service.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]