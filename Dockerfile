# Usa una imagen base con JDK 17
FROM eclipse-temurin:17-jdk-alpine

# Define un argumento para la ubicación del archivo JAR
ARG JAR_FILE=target/demo-1.0-SNAPSHOT.jar

# Copia el archivo JAR en el contenedor
COPY ${JAR_FILE} app.jar

# Expone el puerto 8080 (puerto estándar de Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
