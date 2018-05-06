node {
    stage('gradle') {
        dir = env.JENKINS_HOME
        if(dir==null){
            exit
        }
        sh 'chmod +x gradlew'
        sh './gradlew clean build'
    }
    stage('Sonar Scan') {
      sh 'chmod +x gradlew'
      withSonarQubeEnv('My Sonarqube Server') {
           sh "./gradlew --info -Dsonar.projectKey=Homework:${env.BRANCH_NAME} sonarqube"
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