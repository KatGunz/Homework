node {
    stage('Fetch'){
        git credentialsId: 'github', url: 'https://github.com/KatGunz/Homework'
    }
    stage('Build') {
        sh 'chmod +x gradlew'
        sh './gradlew clean build'
    }
    stage('Test'){
        sh 'chmod +x gradlew'
        sh './gradlew clean test'
    }
    stage('Scan') {
      sh 'chmod +x gradlew'
      withSonarQubeEnv('My Sonarqube Server') {
           sh "./gradlew --info -Dsonar.projectKey=Homework:${env.BRANCH_NAME} sonarqube"
      }
      timeout(time: 5, unit: 'MINUTES') {
          def qg = waitForQualityGate()
          if (qg.status != 'OK') {
              error "Pipeline aborted due to quality gate failure: ${qg.status}"
          }
      }
    }
    stage("Publish"){
        if(env.BRANCH_NAME=="master"){
            kubernetes.image().withName("homework").build().fromPath("./Dockerfile")
            kubernetes.image().withName("homework").tag().inRepository("https://hub.docker.com/r/katgunz/homework/").withTag("latest")
            kubernetes.image().withName("https://hub.docker.com/r/katgunz/homework/").push().withTag("latest").toRegistry()
        }
    }
}