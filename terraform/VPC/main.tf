data "aws_availability_zones" "available" {
    state = "available"
}

resource "aws_vpc" "project-vpc" {
  cidr_block = var.vpc-cidr-block
  instance_tenancy = "default"
  tags = {
    Name = "project-vpc"
    project = "final-project"
  }
}

resource "aws_subnet" "subnet-jenkins" {
  vpc_id                  = aws_vpc.project-vpc.id
  cidr_block              = var.subnet-jenkins-cidr-block
  availability_zone       = data.aws_availability_zones.available.names[0]
  map_public_ip_on_launch = true
  tags = {
    Name = "subnet_jenkins"
    project = "final-project"
  }
}


resource "aws_subnet" "subnetA_RDS" {
  vpc_id                  = aws_vpc.project-vpc.id
  cidr_block              = var.subnetA-RDS-cidr-block
  availability_zone       = data.aws_availability_zones.available.names[0]
  map_public_ip_on_launch = true
  tags = {
    Name = "subnetA_RDS"
    project = "final-project"
  }
}

resource "aws_subnet" "subnetB_RDS" {
  vpc_id                  = aws_vpc.project-vpc.id
  cidr_block              = var.subnetB-RDS-cidr-block
  availability_zone       = data.aws_availability_zones.available.names[1]
  map_public_ip_on_launch = true
  tags = {
    Name = "subnetB_RDS"
    project = "final-project"
  }
}

resource "aws_internet_gateway" "project-igw" {
  vpc_id = aws_vpc.project-vpc.id
  tags = {
    Name = "project-igw"
    project = "final-project"
  }
}

resource "aws_route_table" "project-rt" {
  vpc_id = aws_vpc.project-vpc.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.project-igw.id
  }
  tags = {
    Name = "project-custom-rt"
    project = "final-project"
  }
}

resource "aws_route_table_association" "project-rt-subnet-jenkins" {
  subnet_id      = aws_subnet.subnet-jenkins.id
  route_table_id = aws_route_table.project-rt.id
}


resource "aws_route_table_association" "project-rt-subnetA" {
  subnet_id      = aws_subnet.subnetA_RDS.id
  route_table_id = aws_route_table.project-rt.id
}

resource "aws_route_table_association" "project-rt-subnetB" {
  subnet_id      = aws_subnet.subnetB_RDS.id
  route_table_id = aws_route_table.project-rt.id
}