FROM azul/zulu-openjdk:17
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app/agreement-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/agreement-service.jar"]