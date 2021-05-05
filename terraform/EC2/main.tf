resource "aws_instance" "jenkins" {
  ami                         = var.ami
  instance_type               = var.type
  key_name                    = var.ssh_key
  subnet_id                   = var.subnet_jenkins_id
  vpc_security_group_ids      = var.vpc_security_group_ids
  associate_public_ip_address = true
  lifecycle {
    create_before_destroy = true
  }
  tags = {
    Name = "jenkins-ec2-project"
    project = "final-project"
  }
}
