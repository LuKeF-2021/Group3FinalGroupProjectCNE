pipeline{
    agent any
    environment {
    USERNAME=credentials('docker_username')
    PASSWORD=credentials('docker_password')
    
    // IP_ADDRESS=credentials('') //sort this out
    }
    stages{
        stage('Building and pushing new Docker images'){
            steps{
                sh "chmod +x buildDockerImages.sh"
                sh "buildDockerImages.sh"
                sh "chmod +x buildDockerContainers.sh"
                sh "buildDockerContainers.sh"
            }
        }
        stage('Building docker stuff and Test App'){
            steps{
                sh "chmod +x jenkins/testing.sh"
                sh "jenkins/testing.sh"
            }   
        }
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