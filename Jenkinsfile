pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                bat "mvn clean compile"
            }
        }
       

        stage('deploy') { 
            steps {
                bat "mvn package"
            }
        }


        stage('Build Docker image'){
            steps {
              
                bat 'docker build -t  sanjay872/docker_jenkins_springboot:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login'){
            
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    bat "docker login -u sanjay872 -p ${Dockerpwd}"
                }
            }                
        }

        stage('Docker Push'){
            steps {
                bat 'docker push sanjay872/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }
        
        stage('Docker deploy'){
            steps {
               
                bat 'docker run -itd -p  8085:8085 sanjay872/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }

        
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}