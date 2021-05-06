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
            when { anyOf { branch 'main'; branch pattern: "*backend*", comparator: "GLOB" } }
            steps{
                sh "chmod +x jenkins/create-db.sh"
                sh "jenkins/create-db.sh"
            }
        }
        stage('Building, pushing new Docker images and tests'){
            when { anyOf { branch 'main'; branch pattern: "*backend*", comparator: "GLOB" } }
            steps{
                sh "chmod +x jenkins/buildDockerImages.sh"
                sh "jenkins/buildDockerImages.sh"
                // sh "chmod +x jenkins/testing.sh"
                // sh "jenkins/testing.sh"
                sh "chmod +x jenkins/buildDockerContainers.sh"
                sh "jenkins/buildDockerContainers.sh"
            }
        }
        stage('Remove local images'){
            when { anyOf { branch 'main'; branch pattern: "*backend*", comparator: "GLOB" } }
            steps{
                sh "sudo docker kill frontend"
                sh "sudo docker kill create-ticket-api"
                sh "sudo docker kill read-all-tickets-api"
                sh "sudo docker kill read-ticket-api"
                sh "sudo docker kill delete-ticket-api"
                sh "sudo docker kill update-ticket-api"
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