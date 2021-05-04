#! /bin/bash

ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@${IP_ADDRESS} << EOF
sudo docker stop createTicketService
sudo docker stop readTicketService
sudo docker stop readAllTicketService
sudo docker stop updateTicketService
sudo docker stop deleteTicketService
sudo docker stop ticket-gateway
sudo docker stop discovery-server
sudo docker stop frontend
sudo service docker stop
sudo docker network rm project-network
sudo docker rm -f createTicketService
sudo docker rm -f readTicketService
sudo docker rm -f readAllTicketService
sudo docker rm -f updateTicketService
sudo docker rm -f deleteTicketService
sudo docker rm -f ticket-gateway
sudo docker rm -f discovery-server
sudo docker rm -f frontend
sudo service docker start
EOF