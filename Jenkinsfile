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
  }
}