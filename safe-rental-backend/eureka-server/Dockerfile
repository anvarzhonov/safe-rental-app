FROM azul/zulu-openjdk:17
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app/eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app/eureka-server.jar"]