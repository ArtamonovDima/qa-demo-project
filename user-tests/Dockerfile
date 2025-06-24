FROM eclipse-temurin:21-jdk

WORKDIR /qa-demo-project
ENV TZ=Europe/Moscow

# Копируем всё, чтобы были wrapper, build.gradle, src и зависимости
COPY ./gradle ./gradle
COPY ./user-tests ./user-tests
COPY ./gradlew ./
COPY ./build.gradle ./
COPY ./settings.gradle ./
COPY ./gradle.properties ./

# Запускаем просто UI-тесты
CMD ./gradlew :user-tests:test -Duser.timezone=Europe/Moscow