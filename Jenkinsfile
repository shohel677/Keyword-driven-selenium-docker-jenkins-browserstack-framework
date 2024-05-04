pipeline {
    agent any

    triggers {
        cron('0 0 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/shohel677/selenium-docker.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    docker.image('maven:3.9.3-jdk-11').inside {
                        sh 'mvn clean test -Dbrowser=chrome -DsuiteFile=suites/user_registration.xml'
                    }
                }
            }
        }

        stage('Email Report') {
            steps {
                sh 'cp -r report $WORKSPACE/'
                emailext body: 'Please find attached test report.',
                         subject: 'Selenium Test Report',
                         attachmentsPattern: "$WORKSPACE/report/*.*",
                         to: 'golzarahamedshohel@gmail.com'
            }
        }
    }
}
