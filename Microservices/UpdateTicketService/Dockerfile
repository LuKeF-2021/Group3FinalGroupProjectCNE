FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/UpdateTicketService-*.jar /app/UpdateTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "UpdateTicketService.jar","--spring.datasource.url=$DBURI","--spring.datasource.username=$DBUSER", "--spring.datasource.pass=$DBPASS","--eureka.client.serviceUrl.defaultZone=http://backend-disco:8900/eureka/"]

EXPOSE 8905