pipeline {
  agent any
  stages {
    stage('Contruct Project') {
      agent any
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew build -x test'
      }
    }
  }
}