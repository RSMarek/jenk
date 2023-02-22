#!groovy
import hudson.FilePath



pipeline {
    agent any
    stages {
        stage('load lib') {
            steps {
                script {
                    def workspace = env.WORKSPACE
                    def libPath = "${workspace}/libs/lib.groovy"
                    echo "Loading lib from ${libPath}"
                    def lib = load libPath
                    echo "Loaded lib: ${lib}"
                    echo "Calling meth() method from lib:"
                    lib.sayHello('World')
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