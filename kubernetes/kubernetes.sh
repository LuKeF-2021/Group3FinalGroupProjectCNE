
#!/bin/bash

cd kubernetes/

echo 'creating namespace'
kubectl apply -f namespace.yml

echo 'creating services'
kubectl create -f frontend_service.yml 
kubectl create -f backend_service.yml
kubectl create -f nginxlb.yml

echo 'creating nginx config'
kubectl apply -f nginx_config.yml

echo 'creating deployment files'
kubectl apply -f nginx.yml
kubectl apply -f frontend_deploy.yml
kubectl apply -f backend_deploy.yml