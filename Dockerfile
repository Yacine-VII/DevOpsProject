# Use OpenJDK 17 from Docker Hub
FROM openjdk:17-jdk-slim

# Expose the Spring Boot application port
EXPOSE 8089

# Copy the JAR file from the target directory into the container
COPY target/5DS7-G6_TpFoyer_Devops-5.0.0.jar 5DS7-G6_TpFoyer_Devops-5.0.0.jar

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/5DS7-G6_TpFoyer_Devops-5.0.0.jar"]