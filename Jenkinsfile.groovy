#!groovy
import hudson.FilePath


pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    def workspace = env.WORKSPACE
                    def libs = load "${workspace}/libs/lib.groovy"
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