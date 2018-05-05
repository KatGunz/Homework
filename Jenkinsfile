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
        sonar_url = 'http://66.44.120.253:9002'
        sonar_token = '49969e40ed2b489e7413d9a267d48a1f90894666'
        groupId = 'com.practice.michael'
        artifactId = 'demo'
        sonar_projectKey = '${groupId}:${artifactId}'
      }
      steps {
        sh 'chmod +x gradlew'
        withSonarQubeEnv('My SonarQube Server') {
            sh './gradlew --info -Dsonar.host.url=${sonar_url} -Dsonar.login=${sonar_token} -Dsonar.projectKey=${groupId}:${artifactId} sonarqube'
        }

      }
    }
    stage('Sonar Wait') {
      steps {
        timeout(time: 1, unit: 'HOURS') {
            waitForQualityGate abortPipeline: true
        }
      }
    }
  }
}