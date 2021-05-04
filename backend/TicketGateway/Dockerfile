FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/TicketGateway-*.jar /app/ticketgateway.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "account-api.jar"]

EXPOSE 8899