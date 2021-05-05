output "jenkins_vm_ip" {
  value = module.ec2_instances.jenkins_vm_ip
}

output "jenkins_RDS_Endpoint" {
  value = module.RDS_instances.jenkins_RDS_Endpoint
}
