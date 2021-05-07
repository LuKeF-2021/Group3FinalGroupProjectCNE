#!/bin/bash

echo 'launching cluster'
eksctl create cluster \
--name ProjectCluster \
--region eu-west-1 \
--nodegroup-name ProjectNodes \
--nodes 7 \
--nodes-min 7 \
--nodes-max 8 \
--node-type t2.medium \
--with-oidc \
--ssh-access \
--ssh-public-key teamthree-keypair \
--managed