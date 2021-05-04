#! /bin/bash

ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@${IP_ADDRESS} << EOF
sh './logindocker.sh'
sudo docker login -u $USERNAME -p $PASSWORD
sudo docker network create project-network
sudo docker run -d --network project-network -p 3000:3000 --name frontend lukef2021/frontend:latest 
sudo docker run -d --network project-network -p 8904:8904 --name readTicketService lukef2021/readTicketService:latest
sudo docker run -d --network project-network -p 8903:8903 --name readAllTicketService lukef2021/readTicketService:latest
sudo docker run -d --network project-network -p 8901:8901 --name createTicketService lukef2021/readTicketService:latest
sudo docker run -d --network project-network -p 8905:8905 --name updateTicketService lukef2021/readTicketService:latest
sudo docker run -d --network project-network -p 8902:8902 --name deleteTicketService lukef2021/readTicketService:latest
sudo docker run -d --network project-network -p 8900:8900 --name discovery-server lukef2021/discovery-server:latest
sudo docker run -d --network project-network -p 80:8899 --name ticket-gateway lukef2021/ticket-gateway:latest
EOF