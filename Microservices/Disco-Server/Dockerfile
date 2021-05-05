FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package -DskipTests

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/Disco-Server-*.jar /app/disco-server.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "disco-server.jar"]

EXPOSE 8900