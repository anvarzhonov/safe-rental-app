FROM azul/zulu-openjdk:17
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app/auth-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/auth-service.jar"]