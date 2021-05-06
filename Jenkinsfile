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
        stage('Remove local images'){
            steps{
                sh "sudo docker kill frontend"
                sh "sudo docker kill ticket-gateway"
                sh "sudo docker kill doscovery-server"
                sh "sudo docker system prune -a -f"
            }
        }
        stage('Create database and table'){
            steps{
                sh "chmod +x create-db.sh"
                sh "create-db.sh"
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
        // stage('Building docker stuff and Test App'){
        //     steps{
        //         sh "chmod +x jenkins/testing.sh"
        //         sh "jenkins/testing.sh"
        //     }   
        // }
        // stage('Remove prev containers'){
        //     steps{
        //         sh "cleanContainers.sh"
        //     }
        // }
        
        // stage('Deploy the app'){
        //     steps{
        //         sh "kubernetes.sh"
        //     }
        // }
    }
    
}