pipeline{
    agent any
    environment {
    USERNAME=credentials('docker_username')
    PASSWORD=credentials('docker_password')
    }
    stages{
        stage('Test App'){
            steps{
                sh ""
            }   
        }
        stage('Remove prev containers'){
            steps{
                sh ""
            }
        }
        stage('Building and pushing new Docker images'){
            steps{
                sh ""
            }
        }
        stage('Deploy the app'){
            steps{
                sh ""
            }
        }
    }
    
}