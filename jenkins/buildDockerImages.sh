#! /bin/bash

ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@${IP_ADDRESS} << EOF

# get username and password
source ~/.bash_profile

echo "Docker image building in process"

# finding frontend/Dockerfile
echo "build frontend image started"
cd frontend
sudo docker build -t frontend:latest .
cd ..

# finding backend/Dockerfile
echo "build backend-create images started"
cd backend
cd create
sudo docker build -t createTicketService:latest .
cd ..

echo "build backend-delete images started"
cd backend
cd delete
sudo docker build -t deleteTicketService:latest .
cd ..

echo "build backend-read images started"
cd backend
cd read
sudo docker build -t readTicketService:latest .
cd ..

echo "build backend-readAll images started"
cd backend
cd readAll
sudo docker build -t readAllTicketService:latest .
cd ..

echo "build backend-update images started"
cd backend
cd update
sudo docker build -t updateTicketService:latest .
cd ..

echo "build backend-discoServer images started"
cd backend
cd Discover-Server
sudo docker build -t discovery-server:latest .
cd ..

echo "build backend-gateway images started"
cd backend
cd TicketGateway
sudo docker build -t ticket-gateway:latest .
cd ..


# builds complete by this stage, time to push images to DockerHub

echo "Pushing images to DockerHub"

sh './logindocker.sh'
sudo docker tag readTicketService:latest lukef2021/readTicketService:latest
sudo docker tag createTicketService:latest lukef2021/createTicketService:latest
sudo docker tag updateTicketService:latest lukef2021/updateTicketService:latest
sudo docker tag readAllTicketService:latest lukef2021/readAllTicketService:latest
sudo docker tag deleteTicketService:latest lukef2021/deleteTicketService:latest
sudo docker tag ticket-gateway:latest lukef2021/ticket-gateway:latest
sudo docker tag discover-server:latest lukef2021/discovery-server:latest
sudo docker tag frontend:latest lukef2021/frontend:latest
sudo docker login -u $USERNAME -p $PASSWORD
sudo docker push lukef2021/frontend:latest
sudo docker push lukef2021/readTicketService:latest
sudo docker push lukef2021/createTicketService:latest
sudo docker push lukef2021/readAllTicketService:latest
sudo docker push lukef2021/updateTicketService:latest
sudo docker push lukef2021/deleteTicketService:latest
sudo docker push lukef2021/ticket-gateway:latest
sudo docker push lukef2021/discovery-server:latest


EOF