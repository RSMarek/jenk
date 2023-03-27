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
                    echo "kkk ${CHANGE_SOURCE}"
                }
            }
        }
        stage('sh test') {
            steps {
                script {
                    validate2()
                    setEnv()
                }
            }
        }
        stage('print env') {
            steps {
                script {
                    echo "His name is: ${env.name}. And ha has ${env.age} years old"
                }
            }
        }
    }
}

def validate2(){
    sh """ls -l"""
}

def setEnv(){
    env.name = "Marek"
    env.age = "22"
}

def validate(){
    echo "Running validate"
}
