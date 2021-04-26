resource "aws_security_group" "project-sg" {
  name = "project-security-group"
  vpc_id = var.vpc_id_SG
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = -1
    cidr_blocks = [var.open_internet]
  }
  ingress {
    from_port  = 22
    to_port    = 22
    protocol   = "tcp"
    cidr_blocks = [var.open_internet]
  }
  ingress {
    from_port = 3306
    to_port = 3306
    protocol = "tcp"
    cidr_blocks = [var.configure_vm_cidr]
  }
  ingress {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = [var.configure_vm_cidr]
  }
  ingress {
    from_port = 8080
    to_port = 8080
    protocol = "tcp"
    cidr_blocks = [var.configure_vm_cidr]
  }
  ingress {
    from_port = 5000 #change to port of app
    to_port = 5000 #change to port of app
    protocol = "tcp"
    cidr_blocks = [var.configure_vm_cidr]
  }

  tags = {
    Name = "project-sg-allowing-ssh"
    project = "final-project"
  }
}