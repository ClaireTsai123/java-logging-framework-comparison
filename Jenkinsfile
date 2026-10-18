
pipeline {
    agent any
     environment {
            PATH = "/opt/homebrew/bin:${env.PATH}"
        }


    stages {
        stage('Verify Environment') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Test Logback') {
            steps {
                sh 'mvn -B clean test -Plogback'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Test Log4j2') {
            steps {
                sh 'mvn -B clean test -Plog4j2'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -B clean package -Plogback'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar',
                             fingerprint: true
            echo 'All logging framework tests passed!'
        }

        failure {
            echo 'Build or tests failed. Check the console output.'
        }
    }
}
