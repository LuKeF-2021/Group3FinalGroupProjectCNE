#!/bin/bash

echo 'launching cluster'
eksctl create cluster \
--name ProjectClusterNew \
--region eu-west-1 \
--nodegroup-name ProjectNodes1 \
--nodes 7 \
--nodes-min 2 \
--nodes-max 8 \
--node-type t2.medium \
--with-oidc \
--ssh-access \
--ssh-public-key teamthree-keypair \
--managed