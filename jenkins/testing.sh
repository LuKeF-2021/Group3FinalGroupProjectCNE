#!/bin/bash

# ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@34.240.61.86 << EOF

rm -rf Group3FinalGroupProjectCNE

#cloning my repo
git clone https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE

#cd into project directory
cd Group3FinalGroupProjectCNE
echo "this is the jest tests"
sudo docker-compose up -d --build

# sudo docker exec create-ticket-api bash -c "mvn test"
# sudo docker exec read-ticket-api bash -c "mvn test"
# sudo docker exec update-ticket-api bash -c "mvn test"
# sudo docker exec read-all-tickets-api bash -c "mvn test"
# sudo docker exec delete-ticket-api bash -c "mvn test"
# sudo docker exec ticket-gateway bash -c "mvn test"
# sudo docker exec discovery-server bash -c "mvn test"
sudo docker exec frontend bash -c "npm test -- --coverage --watchAll"

sudo docker-compose down

# EOF