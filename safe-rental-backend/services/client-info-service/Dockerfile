FROM azul/zulu-openjdk:17
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app/user-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/user-service.jar"]