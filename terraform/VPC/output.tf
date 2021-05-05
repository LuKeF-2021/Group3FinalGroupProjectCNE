output "subnet_jenkins_id" {
    value = aws_subnet.subnet-jenkins.id
}

output "subnetA_id" {
    value = aws_subnet.subnetA_RDS.id
}

output "subnetB_id" {
    value = aws_subnet.subnetB_RDS.id
}

output "vpc_id" {
    value = aws_vpc.project-vpc.id
}