#!groovy
import hudson.FilePath
def workspace = env.WORKSPACE
def libs = load "${workspace}/libs/lib.groovy"

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    echo "Building lib..."
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