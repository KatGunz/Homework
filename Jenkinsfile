pipeline {
  agent any
  stages {
    stage('gradle') {
      steps {
        sh './gradlew clean build'
      }
    }
    stage('Sonar Scan') {
      steps {
        sh './gradlew sonarqube'
      }
    }
    stage('Sonar Wait') {
      steps {
        waitForQualityGate()
      }
    }
  }
}