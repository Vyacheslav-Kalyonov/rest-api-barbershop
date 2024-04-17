FROM openjdk:17-oracle
WORKDIR /app

COPY ru.project-0.0.1-SNAPSHOT.jar /app
EXPOSE 8070
CMD ["java", "-jar", "ru.project-0.0.1-SNAPSHOT.jar"]