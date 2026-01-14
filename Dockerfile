FROM openjdk:26-ea-slim

# Set working directory (docker creates a folder /app)
WORKDIR /app

# Copy the JAR file to created folder
COPY target/widgets-ms-1.0.0.jar .

# Default entrypoint (token should be provided via -e environment variables)
ENTRYPOINT ["java", "-jar", "/app/widgets-ms-1.0.0.jar"]

# docker build --tag maratmingazovr/widgets-ms:1.0 .
# docker run \
#  -p 8090:8090 \
#  -e MIRO_TOKEN=miro_token \
#  -e DEFAULT_COLOR=RED \
#  maratmingazovr/widgets-ms:1.0 \
#  --server.port=8090

# -p <host_port>:<container_port>