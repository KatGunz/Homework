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
              // requires SonarQube Scanner for Gradle 2.1+
              // It's important to add --info because of SONARJNKNS-281
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