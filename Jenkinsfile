pipeline {
  agent {
    docker { image 'node:16.13.1-alpine' }
  }
  stages {
    stage('Checkout') {
      steps {
        echo 'hello world'
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nataliechinlw/juice-automation']]])
      }
    }

    stage('Build') {
      steps {
        sh './gradlew clean build'
      }
    }

  }
  triggers {
    pollSCM('0 * * * 1-5')
  }
}