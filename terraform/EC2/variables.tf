variable "ami" {
  description = "machine image"
  default = "ami-06fd78dc2f0b69910"
}

variable "type" {
  description = "machine size"
  default = "t2.medium"
}

variable "ssh_key" {
  description = "key to connect using ssh"
  default = "teamthree-keypair"
}

variable "subnet_jenkins_id" {
  default = "null"
}

variable "vpc_security_group_ids" {
  default = "null"
}