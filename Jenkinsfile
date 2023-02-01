pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nataliechinlw/juice-automation']]])
        sh 'docker run -d --rm -p 3000:3000 bkimminich/juice-shop'
      }
    }

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