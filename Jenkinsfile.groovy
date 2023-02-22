#!groovy

def rootDir = pwd()
def libs = load "${rootDir}@libs/lib.groovy"

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "Building release..."
                libs.meth()
            }
        }
    }
}