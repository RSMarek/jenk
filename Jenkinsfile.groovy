#!groovy
def lib

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    lib = load "libs/lib.groovy"
                    lib.sayHello('World')
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