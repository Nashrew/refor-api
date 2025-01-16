# Use the official Gradle image to build the application
FROM gradle:8.12.0-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

# Use the official OpenJDK image to run the application
FROM openjdk:21-jdk-slim
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]