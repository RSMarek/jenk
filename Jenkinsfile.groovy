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
                    def libClass = new URLClassLoader([new File(libPath).toURI().toURL()]).loadClass("Lib")
                    def lib = libClass.newInstance()
                    echo "Loaded lib: ${lib}"
                    echo "Calling sayHello() method from lib:"
                    lib.sayHello('World')
                    echo "Contents of lib.groovy:"
                    sh "cat ${libPath}"
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