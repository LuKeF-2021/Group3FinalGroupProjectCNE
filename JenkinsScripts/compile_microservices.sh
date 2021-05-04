#Run compiled package

#java -jar name.jar --spring.datasource.url=${db_uri} --spring.datasource.username=${db_user} --spring.datasource.pass=${db_pass}


cd Microservices/Disco-Server
mvn clean package
cd target
java -jar Disco-Server-0.0.1-SNAPSHOT.jar

cd ../../CreateTicketService
mvn clean package
cd target
java -jar CreateTicketService-0.0.1-SNAPSHOT.jar

cd ../../DeleteTicketService
mvn clean package
cd target
java -jar DeleteTicketService-0.0.1-SNAPSHOT.jar

cd ../../ReadAllTicketsService
mvn clean package
cd target
java -jar ReadAllTicketsService-0.0.1-SNAPSHOT.jar

cd ../../ReadTicketService
mvn clean package
cd target
java -jar ReadTicketService-0.0.1-SNAPSHOT.jar

cd ../../UpdateTicketService
mvn clean package
cd target
java -jar UpdateTicketService-0.0.1-SNAPSHOT.jar

cd ../../TicketGateway
mvn clean package
cd target
java -jar TicketGateway-0.0.1-SNAPSHOT.jar
