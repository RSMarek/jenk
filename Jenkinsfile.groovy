#!groovy
def libs
def rootDir = pwd()
// def libs = load "${rootDir}@libs/lib.groovy"

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    libs = new libs.lib()
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