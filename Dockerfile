FROM eclipse-temurin:21-jre

WORKDIR /app

COPY app-launcher/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]