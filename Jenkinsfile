pipeline {
    agent any

    triggers {
        cron('0 0 * * *')
    }

    environment {
        // Define Maven and Java installations
        mvnHome = tool 'Maven'
        javaHome = tool 'Java'
    }

    stages {
        stage('Setup') {
            steps {
                // Checkout Git repository
                git branch: 'main', url: 'https://github.com/shohel677/selenium-docker.git'

                // Pull Selenium Grid Docker images
                script {
                    docker.image('selenium/hub:latest').pull()
                    docker.image('selenium/node-chrome:latest').pull()
                    docker.image('selenium/node-firefox:latest').pull()
                }
            }
        }

        stage('Start Selenium Grid') {
            steps {
                // Start Selenium Grid containers
                script {
                    docker.run("-d", "--name selenium-hub", "selenium/hub:latest")
                    docker.run("-d", "--name selenium-node-chrome", "--link selenium-hub:hub", "selenium/node-chrome:latest")
                    docker.run("-d", "--name selenium-node-firefox", "--link selenium-hub:hub", "selenium/node-firefox:latest")
                }
            }
        }

        stage('Run Tests') {
            steps {
                // Run Selenium tests with specified Maven command
                script {
                    sh "${mvnHome}/bin/mvn clean test -Dbrowser=chrome -DsuiteFile=suites/user_registration.xml -Dplatform=linux"
                }

                // Copy the report file to the workspace
                sh 'cp reports/*.html $WORKSPACE'
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                // Stop Selenium Grid containers
                script {
                    docker.stop('selenium-hub', 'selenium-node-chrome', 'selenium-node-firefox')
                    docker.remove('selenium-hub', 'selenium-node-chrome', 'selenium-node-firefox')
                }
            }
        }

        stage('Email Report') {
            steps {
                emailext (
                    to: 'golzar@gmail.com',
                    subject: 'Test Report',
                    body: 'Attached is the test report.',
                    attachmentsPattern: '$WORKSPACE/*.html'
                )
            }
        }

        stage('Clean Workspace') {
            steps {
                // Clean the workspace
                cleanWs()
            }
        }
    }
}
