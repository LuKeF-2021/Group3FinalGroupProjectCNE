
#!/bin/bash

cd kubernetes/

echo 'creating namespace'
kubectl apply -f namespace.yml

echo 'creating services'
cd ..
cd kubernetes/frontend/
kubectl create -f frontend_service.yml
cd ..
cd backend/ 
kubectl create -f backend_service.yml


cd ..
echo 'creating nginx config'
cd nginx/
kubectl apply -f nginx_config.yml

kubectl create -f nginxlb.yml



echo 'creating deployment files'

kubectl apply -f nginx.yml
cd ..
cd frontend/
kubectl apply -f frontend_deploy.yml
cd ..
cd backend/
kubectl apply -f backend_deploy.yml