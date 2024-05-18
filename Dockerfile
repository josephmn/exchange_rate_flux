FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/exchange_rate_flux-1.0.jar ./exchange_rate_flux-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "exchange_rate_flux-1.0.jar"]