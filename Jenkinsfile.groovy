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
                    if (env.CHANGE_BRANCH ?: false) {
                        echo "THIS IS NOT NULL ${env.CHANGE_BRANCH}"
                    }
                    else{
                        echo "THIS IS NULL ${env.BRANCH_NAME}"
                    }

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
