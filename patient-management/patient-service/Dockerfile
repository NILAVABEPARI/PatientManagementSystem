FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

#FROM openjdk:21-jdk AS runner
# -- the below code replacement is given by claude
FROM eclipse-temurin:21-jre AS runner

WORKDIR /app

COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4501

ENTRYPOINT ["java", "-jar", "app.jar"]