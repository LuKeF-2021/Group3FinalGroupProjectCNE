provider "aws" {
  region = var.region
  shared_credentials_file = "~/.aws/credentials"
}

module "vpc" {
    source = "./VPC"
}

module "security_group" {
    source = "./SG"
    vpc_id_SG = module.vpc.vpc_id
}
 
module "ec2_instances" {
    source = "./EC2"
    subnet_jenkins_id = module.vpc.subnet_jenkins_id
    vpc_security_group_ids = [module.security_group.my_sg_id]
}

module "RDS_instances" {
    username = var.username
    password = var.password
    source = "./RDS"
    subnetA_RDS_id = module.vpc.subnetA_id
    subnetB_RDS_id = module.vpc.subnetB_id
    vpc_security_group_ids = [module.security_group.my_sg_id]
}
