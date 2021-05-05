#!/bin/bash
set -e

cd ../terraform

terraform init
terraform plan
terraform apply

export jenkins_ip = terraform output -raw jenkins_vm_ip

export rds_endpoint = terraform output -raw jenkins_RDS_Endpoint
# cd ..
# cd ../ansible



