#! /bin/bash

# ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@34.240.61.86 << EOF
# sh './logindocker.sh'
sudo docker login -u $USERNAME -p $PASSWORD

# sudo docker network create project-network
# sudo docker run -d --name discovery-server discovery-server:latest
# sudo docker run -d --name ticket-gateway ticket-gateway:latest
# sudo docker run -d --name read-ticket-api readticketservice:latest
# sudo docker run -d --name read-all-tickets-api readallticketservice:latest
# sudo docker run -d --name create-ticket-api createticketservice:latest
# sudo docker run -d --name update-ticket-api updateticketservice:latest
# sudo docker run -d --name delete-ticket-api deleteticketservice:latest
# sudo docker run -d --name frontend frontend:latest
docker-compose up -d

# EOF