#!groovy

def rootDir = pwd()
// def libs = load "${rootDir}@libs/lib.groovy"

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    def libs = load "${rootDir}@libs/lib.groovy"
                    libs.meth()
                }
            }
        }
        stage('Build') {
            steps {
                echo "Building release..."
                validate()
            }
        }
    }
}

def validate(){
    echo "Running validate"
}