variable "vpc-cidr-block" {
    default = "20.0.0.0/16"
}

variable "subnet-jenkins-cidr-block" {
    default = "20.0.1.0/24"
}


variable "subnetA-RDS-cidr-block" {
    default = "20.0.2.0/24"
}

variable "subnetB-RDS-cidr-block" {
    default = "20.0.3.0/24"
}

variable "subnet_jenkins_id" {
    default = "null"
}
