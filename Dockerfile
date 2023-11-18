FROM openjdk:19-jdk-alpine3.16

EXPOSE 8080

COPY target/JdRESTAuthorization-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]