pipeline {
  agent any
  stages {
    stage('Contruct Project') {
      agent any
      steps {
        git(url: 'https://github.com/KatGunz/Homework.git', branch: 'development', changelog: true)
        sh 'ls'
        sh 'chmod +x gradlew'
        sh './gradlew build'
      }
    }
  }
}