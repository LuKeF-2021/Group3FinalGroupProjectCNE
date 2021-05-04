FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/DeleteTicketService-*.jar /app/DeleteTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "DeleteTicketService.jar"]

EXPOSE 8902