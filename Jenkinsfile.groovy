#!groovy
import hudson.FilePath



pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    def workspace = env.WORKSPACE
                    def lib = load "${workspace}/libs/lib.groovy"
                    echo "Loaded lib: ${lib}"
                    echo "Calling meth() method from lib:"
                    lib.meth()
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