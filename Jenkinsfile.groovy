#!groovy

def rootDir = pwd()
// def libs = load "${rootDir}@libs/lib.groovy"

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                libs = load "${rootDir}@libs/lib.groovy"
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