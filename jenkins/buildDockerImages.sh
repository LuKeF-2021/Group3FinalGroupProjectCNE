#! /bin/bash

# ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@34.240.61.86 << EOF

# get username and password
# source ~/.bash_profile

echo "Docker image building in process"

# finding frontend/Dockerfile
echo "build frontend image started"
cd frontend
sudo docker build -t frontend:latest .
cd ..

# finding backend/Dockerfile
echo "build backend-create images started"
cd Microservices
cd CreateTicketService
sudo docker build -t createticketservice:latest .
cd ..

echo "build backend-delete images started"

cd delete
sudo docker build -t deleteticketservice:latest .
cd ..

echo "build backend-read images started"

cd read
sudo docker build -t readticketservice:latest .
cd ..

echo "build backend-readAll images started"

cd readAll
sudo docker build -t readallticketservice:latest .
cd ..

echo "build backend-update images started"

cd update
sudo docker build -t updateticketservice:latest .
cd ..

echo "build backend-discoServer images started"

cd Discover-Server
sudo docker build -t discovery-server:latest .
cd ..

echo "build backend-gateway images started"

cd TicketGateway
sudo docker build -t ticket-gateway:latest .
cd ..


# builds complete by this stage, time to push images to DockerHub

echo "Pushing images to DockerHub"

# sh './logindocker.sh'
sudo docker tag readticketservice:latest lukef2021/readticketservice:latest
sudo docker tag createticketservice:latest lukef2021/createticketservice:latest
sudo docker tag updateticketservice:latest lukef2021/updateticketservice:latest
sudo docker tag readallticketservice:latest lukef2021/readallticketservice:latest
sudo docker tag deleteticketservice:latest lukef2021/deleteticketservice:latest
sudo docker tag ticket-gateway:latest lukef2021/ticket-gateway:latest
sudo docker tag discover-server:latest lukef2021/discovery-server:latest
sudo docker tag frontend:latest lukef2021/frontend:latest
sudo docker login -u $USERNAME -p $PASSWORD
sudo docker push lukef2021/frontend:latest
sudo docker push lukef2021/readticketservice:latest
sudo docker push lukef2021/createticketservice:latest
sudo docker push lukef2021/readallticketservice:latest
sudo docker push lukef2021/updateticketservice:latest
sudo docker push lukef2021/deleteticketservice:latest
sudo docker push lukef2021/ticket-gateway:latest
sudo docker push lukef2021/discovery-server:latest


# EOF