pipeline {
  agent any
  stages {
    stage('Construct') {
      steps {
        sh 'chmod +x gradlew '
        sh '''
        ./gradlew clean build'''
      }
    }
  }
}