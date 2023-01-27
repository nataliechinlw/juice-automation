pipeline {
  agent any
  stages {
    stage('Hello World') {
      steps {
        echo 'hello world'
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nataliechinlw/juice-automation']]])
      }
    }

  }
  triggers {
    pollSCM('0 * * * 1-5')
  }
}