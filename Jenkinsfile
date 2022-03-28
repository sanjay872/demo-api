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
        
        
//        stage('run app'){
//        	steps {
//        		bat 'java -jar target/demo-api-0.0.1-SNAPSHOT.jar'
//        	}
//        }
        

        stage('Build Docker image'){
            steps {              
             bat 'docker build -t  sanjay872/docker_jenkins_springboot:%BUILD_NUMBER% .'
           }
        }

        stage('Docker Login'){           
            steps {
                   withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    bat "docker login -u sanjay872 -p %Dockerpwd%"
                }
           }                
        }
        
 
        stage('Docker Push'){
            steps {
               bat 'docker push sanjay872/docker_jenkins_springboot:%BUILD_NUMBER%'
            }
        }
        
        stage('Docker deploy'){
            steps {
            	script {
            		try {
            			bat 'docker rm -f demo-api'
            		}
            		catch (error) {
            			echo 'no image exist'
            		}
            		finally {
            			bat 'docker run --name demo-api -itd -p  8085:8085 sanjay872/docker_jenkins_springboot:%BUILD_NUMBER%'
            			bat 'docker image prune -a'
            		}
            	}
            }
        }

        
//      	 stage('Archving') { 
//          steps {
//               archiveArtifacts '**/target/*.jar'
//           }
//        }
    }
}