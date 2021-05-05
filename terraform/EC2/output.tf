output "jenkins_vm_ip" {
    value = aws_instance.jenkins.public_ip
}
