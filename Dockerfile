FROM openjdk:17 AS build
WORKDIR /app
COPY microservicio/gradlew /app/gradlew
COPY microservicio/gradle /app/gradle
COPY microservicio/build.gradle /app/build.gradle
COPY microservicio/settings.gradle /app/settings.gradle
COPY microservicio/gradle.properties /app/gradle.properties
RUN chmod +x /app/gradlew
RUN ./gradlew build --no-daemon

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/mi-app.jar /app/mi-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mi-app.jar"]