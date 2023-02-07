pipeline{
    agent any
        tools {
            maven 'M3'
        }

        environment {
            dockerHubRegistry = 'kjh99723/jaksim31-backend'
            dockerHubRegistryCredential = 'dockerhub'
            dockerImageName = 'jaksim31-backend'
            gitCredentialId = 'github'
            gitSrcUrl = 'git@github.com:KIM-JOOHYUN/jaksim31-backend.git'
            gitPropertiesUrl = 'git@github.com:KSWA-SWEEP/jaksim31-properties.git'
        }

        stages{
            stage('Checkout Properties Git Branch'){
                agent any
                steps{
                    git credentialsId: "${gitCredentialId}",
                        url: "${gitPropertiesUrl}",
                        branch: 'main'
                }
                post{
                    failure{
                        echo '!! Repository clone failure1!!'
                    }
                    success{
                        echo 'Repository clone success!!'
                    }
                }
            }
            stage('Maven Jar Build') {
                steps {
                    sh 'mvn clean install -Dspring.profiles.active=local -P local'
                }
                post {
                        failure {
                          slackSend (channel: '#jenkins', color: '#FF0000', message: "Maven jar Build Failure !: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                          echo 'Maven  jar build failure !'
                        }
                        success {
                          echo 'Maven jar build success !'
                        }
                }
            }
        }
}