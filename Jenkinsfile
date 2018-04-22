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
    stage('Sonar') {
      steps {
        waitForQualityGate true
      }
    }
  }
}