# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY . .

# Expose the port that your Spring Boot application listens on
EXPOSE 8082

# Specify any environment variables if needed
# ENV VARIABLE_NAME=value

# Command to run the application
CMD ["java", "-jar", "target/BackendApplication.war"]
