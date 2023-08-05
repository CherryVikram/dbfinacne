# Use the official OpenJDK image as the base image
FROM openjdk:20-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY build/libs/finance-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application is running on
EXPOSE 8080

# Define environment variables for connecting to PostgreSQL
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-cj77p0tjeehc73d017m0-a.singapore-postgres.render.com/finance_m018
ENV SPRING_DATASOURCE_USERNAME=cherry
ENV SPRING_DATASOURCE_PASSWORD=6GTZ0c4AgupaiMhaomlPyUovvwcwqYy2

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]