FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/DeleteTicketService-*.jar /app/DeleteTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "DeleteTicketService.jar","--spring.datasource.url=${db_uri}","--spring.datasource.username=${db_user}", "--spring.datasource.pass=${db_pass}","--eureka.client.serviceUrl.defaultZone=http://discovery-server:8900/eureka/"]

EXPOSE 8902