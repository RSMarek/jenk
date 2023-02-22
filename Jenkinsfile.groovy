#!groovy

// def libs = new libs.lib();

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "Building release..."
                // libs.meth()
            }
        }
    }
}