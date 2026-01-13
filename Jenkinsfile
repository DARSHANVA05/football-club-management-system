pipeline {
    agent none

    stages {
        stage('Checkout') {
            agent{label "football-checkout"}
            steps {
                checkout scm
            }
        }

        stage('Build') {
            agent{label "football-build"}
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            agent{label "football-test"}
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target\\surefire-reports\\*.xml'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and tests passed!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
