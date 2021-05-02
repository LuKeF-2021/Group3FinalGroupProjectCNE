#Run disco server

cd Microservices/CreateTicketService
mvn test

#Download dependencies?

mvn dependency:tree

#Compile
#mvn compile

#Compile and run?
#mvn spring-boot:run

#Build/compile?
mvn clean package


#Run compiled package

java -jar name.jar --spring.datasource.url=${db_uri} --spring.datasource.username=${db_user} --spring.datasource.pass=${db_pass}
