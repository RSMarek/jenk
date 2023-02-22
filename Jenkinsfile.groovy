#!groovy
def kek

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    def lib = load "libs/lib.groovy"
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