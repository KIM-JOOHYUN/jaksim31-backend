pipeline{
    agent any
        tools {
            maven 'M3'
        }

        environment {
            dockerHubRegistry = 'kjh99723/jaksim31-backend'
            dockerImageName = 'jaksim31-backend'
            dockerHubRegistryCredential = 'dockerhub'
            sonarqubeCredential = '3b91d326-8669-4897-bbe0-a56eeca65131'
        }

        stages{
            stage('Maven Jar Build') {
                steps {
                    sh 'mvn clean install -Dspring.profiles.active=local -P local'
                }

                post {
                        failure {
                          echo 'Maven  jar build failure !'
                        }
                        success {
                          echo 'Maven jar build success !'
                        }
                }
            }
            stage('SonarQube analysis') {
               steps {
                   withSonarQubeEnv('SonarQube') {
                       dir('backend') {
                           sh './gradlew sonarqube'
                       }
                   }
               }
           }
        }
}