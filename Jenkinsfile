pipeline {
  agent any
  stages {
    stage('Build') {
      agent {
        docker {
          image 'bkimminich/juice-shop'
          args '''-p 3000:3000
--user root
-v /var/run/docker.sock:/var/run/docker.sock'''
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