pipeline {
    agent any 
    stages {
	stage('checkout') {
	    steps {
		git url: 'https://github.com/Prateeksrt/heavy-task-backend.git'
	    }
	}
        stage('build') {
            steps {
                sh './graldew clean build' 
            }
        }
    }
}
