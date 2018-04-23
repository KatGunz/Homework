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
              sh './gradlew --info sonarqube'
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