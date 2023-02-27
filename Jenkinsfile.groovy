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
                    lib.validate2()
                }
            }
        }
        stage('sh test') {
            steps {
                script {
                    validate2()
                }
            }
        }
    }
}

def validate2(){
    sh """ls -l"""
}

def validate(){
    echo "Running validate"
}
