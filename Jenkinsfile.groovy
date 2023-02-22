#!groovy
// def libs
// def rootDir = pwd()
import hudson.FilePath


def libs = load "${WORKSPACE}/libs/lib.groovy"

pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    echo "Building lib..."
                    // libs = load "libs/lib.groovy"
                    // libs.meth()
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