FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/ReadAllTicketService-*.jar /app/ReadAllTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "ReadAllTicketService.jar"]

EXPOSE 8903