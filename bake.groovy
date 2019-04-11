pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/AGES-PUCRS/mase-user-service.git'
            }
        }
        stage('Build') {
            steps {
                sh 'docker build -t mase/user-service .'
            }
        }
    }
}