FROM azul/zulu-openjdk:17

ARG JAR_FILE=/target/*.jar
ENV SERVICE_NAME=box-service

COPY ${JAR_FILE} app/box-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/box-service.jar"]