pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        sh './gradlew clean build'
      }
    }

  }
  triggers {
    pollSCM('0 * * * 1-5')
  }
}