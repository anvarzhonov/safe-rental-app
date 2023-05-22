FROM azul/zulu-openjdk:17

ARG JAR_FILE=/target/*.jar
ENV SERVICE_NAME=calculations-service

COPY ${JAR_FILE} app/calculations-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/calculations-service.jar"]