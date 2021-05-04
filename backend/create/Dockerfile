FROM maven:latest as build-stage

COPY . /build

WORKDIR /build

RUN mvn clean package

FROM openjdk:latest as run-time

COPY --from=build-stage /build/target/CreateTicketService-*.jar /app/CreateTicketService.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "CreateTicketService.jar","--spring.datasource.url=${db_uri}","--spring.datasource.username=${db_user}", "--spring.datasource.pass=${db_pass}"]

EXPOSE 8901