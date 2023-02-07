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
                    sh './mvnw clean install -Dspring.profiles.active=local -P local'
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
                      sh './mvnw sonar:sonar -Dsonar.java.binaries=target/classes -Dsonar.host.url=http://210.109.61.124:8080 -Dsonar.projectKey=test -Dsonar.projectName=4568 -Dsonar.login=sqa_20f91e5fcfb538fc4909b69ab5f8bb63a896f129'
               }
           }
        }
}