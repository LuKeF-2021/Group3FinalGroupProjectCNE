FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/ReadAllTicketsService-*.jar /app/ReadAllTicketsService.jar

WORKDIR /app

ENTRYPOINT java -jar ReadAllTicketsService.jar --spring.datasource.url=$DBURI --spring.datasource.username=$DBUSER --spring.datasource.pass=$DBPASS --eureka.client.serviceUrl.defaultZone=backend-disco:8900/eureka/

EXPOSE 8903