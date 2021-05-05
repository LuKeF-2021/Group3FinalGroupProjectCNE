#!/bin/bash

# ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@34.240.61.86 << EOF

rm -rf Group3FinalGroupProjectCNE

#cloning my repo
git clone https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE

#cd into project directory
cd Group3FinalGroupProjectCNE

docker-compose up -d --build

docker exec create-ticket-api bash -c "mvn test"
docker exec read-ticket-api bash -c "mvn test"
docker exec update-ticket-api bash -c "mvn test"
docker exec read-all-tickets-api bash -c "mvn test"
docker exec delete-ticket-api bash -c "mvn test"
docker exec ticket-gateway bash -c "mvn test"
docker exec discovery-server bash -c "mvn test"

docker-compose down

# EOF