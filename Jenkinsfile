pipeline {
    agent any

    stages {
        stage('Install Tools') {
            steps {
                script {
                    // Install JDK
                    tool name: 'Java', type: 'jdk'

                    // Install Maven
                    def mvnHome = tool name: 'Maven', type: 'maven'

                    // Add Maven and Java to PATH
                    env.PATH = "${mvnHome}:${env.PATH}"
                    env.PATH += ":${tool 'Java'}/bin"

                    // Print Java and Maven versions
                    sh 'java -version'
                    sh 'mvn -version'
                }
            }
        }

        stage('Checkout') {
            steps {
                // Checkout Maven Selenium Java project from Git
                git branch: 'main', url: 'https://github.com/shohel677/selenium-docker.git'
            }
        }

        stage('Build') {
            steps {
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
                    archiveArtifacts(artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true)
                }
            }
        }

        stage('Email Report') {
            steps {
                script {
                    // Copy test report to workspace
                    sh 'cp -r report $WORKSPACE/'
                    // Send email with attached test report
                    emailext body: 'Please find attached test report.',
                             subject: 'Selenium Test Report',
                             attachmentsPattern: "$WORKSPACE/report/*.*",
                             to: 'golzarahamedshohel@gmail.com'
                }
            }
            post {
                always {
                    // Clean workspace
                    cleanWs()
                }
            }
        }
    }
}
