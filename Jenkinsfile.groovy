#!groovy
import hudson.FilePath

def libs

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    def workspace = env.WORKSPACE
                    libs = load "${workspace}/libs/lib.groovy"
                    echo "Building lib..."
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