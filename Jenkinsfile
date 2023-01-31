pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        echo 'hello world'
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nataliechinlw/juice-automation']]])
      }
    }

    stage('Build') {
      agent {
        docker {
          image 'bkimminich/juice-shop'
          args '-p 3000:3000'
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