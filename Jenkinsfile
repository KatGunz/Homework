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
        timeout(time: 1, unit: 'HOURS') {
            waitForQualityGate abortPipeline: true
        }
      }
    }
  }
}