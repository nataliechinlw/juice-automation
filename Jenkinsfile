pipeline {
  agent any
  stages {
    stage('Hello World') {
      steps {
        echo 'hello world'
        git(url: 'https://github.com/nataliechinlw/juice-automation', changelog: true, poll: true, branch: '*/main')
      }
    }

  }
  triggers {
    pollSCM('0 * * * 1-5')
  }
}