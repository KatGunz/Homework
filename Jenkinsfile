pipeline {
  agent any
  stages {
    stage('gradle') {
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew clean build'
      }
    }
    stage('Sonar Scan') {
      agent any
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew --info sonarqube'
      }
    }
    stage('Sonar Wait') {
      steps {
        waitForQualityGate()
      }
    }
  }
}