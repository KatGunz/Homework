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
      environment {
        sonar_host = 'http://66.44.120.253:9002'
        sonar_login = 'a99793310f532f6d993c4df41dfa564f73fe93d6'
      }
      steps {
        sh './gradlew --info sonarqube -Dsonar.host.url=${sonar_host} -DSonar.login=${sonar_login}'
      }
    }
    stage('Sonar Wait') {
      steps {
        waitForQualityGate()
      }
    }
  }
}