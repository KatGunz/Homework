pipeline {
  agent any
  stages {
    stage('Construct') {
      steps {
        sh './gradlew clean build -x test'
      }
    }
  }
}