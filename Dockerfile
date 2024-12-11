FROM eclipse-temurin:21-alpine
WORKDIR /app

COPY target/probes-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
