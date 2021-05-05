#! /bin/bash

ssh -o StrictHostKeyChecking=no -i /home/jenkins/.ssh/id_rsa ubuntu@34.240.61.86 << EOF
sudo docker stop create-ticket-api
sudo docker stop read-ticket-api
sudo docker stop read-all-tickets-api
sudo docker stop update-ticket-api
sudo docker stop delete-ticket-api
sudo docker stop ticket-gateway
sudo docker stop discovery-server
sudo docker stop frontend
sudo service docker stop
sudo docker network rm project-network
sudo docker rm -f create-ticket-api
sudo docker rm -f read-ticket-api
sudo docker rm -f read-all-tickets-api
sudo docker rm -f update-ticket-api
sudo docker rm -f delete-ticket-api
sudo docker rm -f ticket-gateway
sudo docker rm -f discovery-server
sudo docker rm -f frontend
sudo service docker start
EOF