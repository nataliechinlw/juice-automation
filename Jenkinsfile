pipeline {
  agent any
  stages {
    stage('Build') {
      agent {
        docker {
          image 'node:16.13.1-alpine'
        }

      }
      steps {
        sh './gradlew clean build'
      }
    }

  }
  triggers {
    pollSCM('0 * * * 1-5')
  }
}