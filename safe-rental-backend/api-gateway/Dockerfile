FROM azul/zulu-openjdk:17

ARG JAR_FILE=/target/*.jar
ENV SERVICE_NAME=api-gateway

COPY ${JAR_FILE} app/api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/api-gateway.jar"]