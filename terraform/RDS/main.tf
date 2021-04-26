resource "aws_db_instance" "jenkins-db" {
    allocated_storage = 20
    storage_type = "gp2"
    engine = "mysql"
    engine_version = "5.7"
    instance_class = "db.t2.micro"
    name = "jenkins_db"
    username = var.username
    password = var.password
    parameter_group_name = "default.mysql5.7"
    db_subnet_group_name = aws_db_subnet_group.default.name
    vpc_security_group_ids = var.vpc_security_group_ids
    skip_final_snapshot = true
    identifier = "project-jenkins-db"
    
    tags = {
       Name = "project-jenkins-RDS"
       project = "final-project"

    }
}


resource "aws_db_subnet_group" "default" {
    name = "main"
    subnet_ids = [var.subnetA_RDS_id, var.subnetB_RDS_id]

    tags = {
        Name = "rdb-subnet-group"
        project = "practical-project"
    }
}