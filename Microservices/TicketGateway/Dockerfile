FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package -DskipTests

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/TicketGateway*.jar /app/ticketgateway.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "ticketgateway.jar","--eureka.client.serviceUrl.defaultZone=http://discovery-server:8900/eureka/"]

EXPOSE 8899