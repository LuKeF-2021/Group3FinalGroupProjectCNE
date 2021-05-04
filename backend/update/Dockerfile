FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/UpdateTicketService-*.jar /app/UpdateTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "UpdateTicketService.jar"]

EXPOSE 8905