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
  post {
    always {
      junit 'build/reports/**/*.xml'
    }
  }
  triggers {
    pollSCM('0 * * * 1-5')
  }
}