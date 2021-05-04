#!/bin/bash

ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@${IP_ADDRESS} << EOF

rm -rf Group3FinalGroupProjectCNE

#cloning my repo
git clone https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE

#cd into project directory
cd Group3FinalGroupProjectCNE

docker-compose up -d --build

docker exec createTicketService bash -c "mvn test"
docker exec readTicketService bash -c "mvn test"
docker exec updateTicketService bash -c "mvn test"
docker exec readAllTicketService bash -c "mvn test"
docker exec deleteTicketService bash -c "mvn test"
docker exec ticket-gateway bash -c "mvn test"
docker exec discovery-server bash -c "mvn test"

docker-compose down

EOF