pipeline{
    agent any
    environment {
    USERNAME=credentials('docker_username')
    PASSWORD=credentials('docker_password')
    DBURI=credentials('db_uri')
    DBUSER=credentials('db_user')
    DBPASS=credentials('db_pass')
    
    // IP_ADDRESS=credentials('') //sort this out
    }
    stages{
        
        stage('Create database and table'){
            steps{
                sh "chmod +x jenkins/create-db.sh"
                sh "jenkins/create-db.sh"
            }
        }
        stage('Building, pushing new Docker images and tests'){
            steps{
                sh "chmod +x jenkins/buildDockerImages.sh"
                sh "jenkins/buildDockerImages.sh"
                sh "chmod +x jenkins/buildDockerContainers.sh"
                sh "jenkins/buildDockerContainers.sh"
            }
        }
        stage('Remove local images'){
            steps{
                sh "sudo docker kill frontend"
                sh "sudo docker kill createticketservice"
                sh "sudo docker kill readallticketservice"
                sh "sudo docker kill readticketservice"
                sh "sudo docker kill deleteticketservice"
                sh "sudo docker kill updateticketservice"
                sh "sudo docker kill ticket-gateway"
                sh "sudo docker kill discovery-server"
                sh "sudo docker system prune -a -f"
            }
        }
        stage('Deploy the app'){
            steps{
                sh "chmod +x jenkins/kubernetes.sh"
                sh "jenkins/kubernetes.sh"
            }
        }
    }
    
}