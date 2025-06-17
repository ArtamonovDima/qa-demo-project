FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY build/libs/user-auth-service.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]