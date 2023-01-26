pipeline {
  agent any
  triggers {
    pollSCM('0 * * * 1-5')
  }
  stages {
    stage('Hello World') {
      steps {
        echo 'hello world'
      }
    }

  }
}