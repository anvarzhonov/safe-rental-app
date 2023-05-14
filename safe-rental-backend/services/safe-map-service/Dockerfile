FROM azul/zulu-openjdk:17

ARG JAR_FILE=/target/*.jar
ENV SERVICE_NAME=safe-map-service

COPY ${JAR_FILE} app/safe-map-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/safe-map-service.jar"]