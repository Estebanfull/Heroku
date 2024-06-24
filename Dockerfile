FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the necessary files into the container
COPY . .

# Install dependencies and build the application
RUN ./mvnw clean install -DskipTests

# Specify the command to run the application
CMD ["java", "-jar", "target/your-spring-boot-app.jar"]
