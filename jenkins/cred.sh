#!/bin/bash
echo "creating the secret"
kubectl create secret docker-registry cred \
--docker-username=$USERNAME \
--docker-password=$PASSWORD \
--docker-email=$EMAIL

