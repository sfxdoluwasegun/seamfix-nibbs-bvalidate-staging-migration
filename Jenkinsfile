pipeline {
	agent any
	tools {
		maven 'mvn339'
		jdk 'jdk8'
	}

	stages {
		stage('Build') {
			steps {
				echo 'Running build'
				sh 'mvn clean package -U'
			withSonarQubeEnv('sonarQube_Main') {
				sh 'mvn sonar:sonar ' +
				'-Dsonar.projectKey=nibbs-bvalidate-staging-key ' +
			        '-Dsonar.projectName=nibbs-bvalidate-staging'
				}
				archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
			}
		}
		stage('Deploy') {
			steps {
				echo 'Deploy build'
				sh 'mvn clean package deploy'
				archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
			}
		}

	}
}
