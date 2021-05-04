FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/ReadTicketService-*.jar /app/ReadTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "ReadTicketService.jar"]

EXPOSE 8901