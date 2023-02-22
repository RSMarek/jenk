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
                script {
                    echo "Building release..."
                    validate()
                    lib.sayHello('Build')
                }
            }
        }
    }
}

def validate(){
    echo "Running validate"
}