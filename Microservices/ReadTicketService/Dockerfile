FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/ReadTicketService-*.jar /app/ReadTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "ReadTicketService.jar","--spring.datasource.url=$DBURI","--spring.datasource.username=$DBUSER", "--spring.datasource.pass=$DBPASS","--eureka.client.serviceUrl.defaultZone=http://discovery-server:8900/eureka/"]

EXPOSE 8901