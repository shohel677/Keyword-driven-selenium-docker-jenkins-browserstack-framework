pipeline {
    agent any

    triggers {
        cron('0 0 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/your-username/your-repository.git'
            }
        }

        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.3-jdk-11'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean test -Dbrowser=chrome -DsuiteFile=suites/user_registration.xml'
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