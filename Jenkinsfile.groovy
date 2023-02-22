#!groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "Building release..."
            }
        }
    }
}