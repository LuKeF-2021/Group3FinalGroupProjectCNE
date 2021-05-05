pipeline{
    agent any
    environment {
    USERNAME=credentials('docker_username')
    PASSWORD=credentials('docker_password')
    
    // IP_ADDRESS=credentials('') //sort this out
    }
    stages{
        stage('Test App'){
            steps{
                sh "chmod +x jenkins/testing.sh"
                sh "jenkins/testing.sh"
            }   
        }
        stage('Remove prev containers'){
            steps{
                sh "cleanContainers.sh"
            }
        }
        stage('Building and pushing new Docker images'){
            steps{
                sh "buildDockerImages.sh"
                sh "buildDockerContainers.sh"
            }
        }
        // stage('Deploy the app'){
        //     steps{
        //         sh "kubernetes.sh"
        //     }
        // }
    }
    
}