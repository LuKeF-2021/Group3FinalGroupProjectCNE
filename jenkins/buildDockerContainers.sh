#! /bin/bash

# ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@34.240.61.86 << EOF
# sh './logindocker.sh'
sudo docker login -u $USERNAME -p $PASSWORD
# sudo docker network create project-network
sudo docker run discovery-server:latest
sudo docker run ticket-gateway:latest
sudo docker run readticketservice:latest
sudo docker run readallticketservice:latest
sudo docker run createticketservice:latest
sudo docker run updateticketservice:latest
sudo docker run deleteticketservice:latest
# sudo docker run frontend:latest

# EOF