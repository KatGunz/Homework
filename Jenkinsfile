pipeline {
  agent any
  stages {
    stage('Gradle') {
      steps {
        sh 'chmod +x gradlew '
        sh '''
        ./gradlew clean build'''
      }
    }
    stage('SonarQube analysis') {
        steps{
            withSonarQubeEnv('My SonarQube Server') {
              sh './gradlew --info sonarqube \
                 -Dsonar.host.url=http://66.44.120.253:9002 \
                -Dsonar.login=a99793310f532f6d993c4df41dfa564f73fe93d6'
            }
        }
     }
    stage('Sonar') {
      steps {
        waitForQualityGate true
      }
    }
  }
}