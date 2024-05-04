pipeline {
    agent any

    triggers {
        cron('0 0 * * *')
    }

    stages {
        stage('Build') {
            steps {
                // Checkout your Maven Selenium Java project from Git
                git 'https://github.com/shohel677/selenium-docker.git'

                // Build Maven project
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run Selenium tests
                sh 'mvn clean test -Dbrowser=edge -DsuiteFile=suites/user_registration.xml -Dplatform=linux'
            }
            post {
                always {
                    // Archive the test reports
                    archiveArtifacts(artifacts: '$WORKSPACE/report/*.*', allowEmptyArchive: true)
                }
            }
        }

        stage('Email Report') {
            steps {
                script {
                    sh 'cp -r report $WORKSPACE/'
                    emailext body: 'Please find attached test report.',
                             subject: 'Selenium Test Report',
                             attachmentsPattern: "$WORKSPACE/report/*.*",
                             to: 'golzarahamedshohel@gmail.com'
                }
            }
            post {
                always {
                    cleanWs()
                }
            }
        }
    }
}