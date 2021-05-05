#! /bin/bash

# ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@34.240.61.86 << EOF
# sh './logindocker.sh'
sudo docker login -u $USERNAME -p $PASSWORD
sudo docker network create project-network
sudo docker run -d --network project-network -p 3000:3000 --name lukef2021/frontend:latest 
sudo docker run -d --network project-network -p 8904:8904 --name lukef2021/readTicketService:latest
sudo docker run -d --network project-network -p 8903:8903 --name lukef2021/readAllTicketService:latest
sudo docker run -d --network project-network -p 8901:8901 --name lukef2021/createTicketService:latest
sudo docker run -d --network project-network -p 8905:8905 --name lukef2021/updateTicketService:latest
sudo docker run -d --network project-network -p 8902:8902 --name lukef2021/deleteTicketService:latest
sudo docker run -d --network project-network -p 8900:8900 --name lukef2021/discovery-server:latest
sudo docker run -d --network project-network -p 80:8899 --name lukef2021/ticket-gateway:latest
# EOF