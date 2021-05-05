FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package -DskipTests

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/CreateTicketService-*.jar /app/CreateTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "CreateTicketService.jar","--spring.datasource.url=${db_uri}","--spring.datasource.username=${db_user}", "--spring.datasource.pass=${db_pass}","--eureka.client.serviceUrl.defaultZone=http://discovery-server:8900/eureka/"]

EXPOSE 8901