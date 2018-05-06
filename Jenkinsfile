node {
    stage('gradle') {
        sh 'chmod +x gradlew'
        sh './gradlew clean build'
    }
    stage('Sonar Scan') {
      echo 'current branch: ${env.BRANCH_NAME}'
      sh 'chmod +x gradlew'
      withSonarQubeEnv('My Sonarqube Server') {
           sh './gradlew --info sonarqube'
      }
    }
    stage("Quality Gate"){
        timeout(time: 5, unit: 'MINUTES') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
    }
}