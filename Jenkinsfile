pipeline {
    agent any

    stages {
        stage('Setup Docker') {
            steps {
                script {
                    // Install Docker
                    sh 'curl -fsSL https://get.docker.com -o get-docker.sh'
                    sh 'sh get-docker.sh'

                    // Add Jenkins user to docker group
                    sh 'sudo usermod -aG docker jenkins'

                    // Start Docker service
                    sh 'sudo systemctl start docker'

                    // Pull Selenium Grid Docker images
                    docker.image('selenium/hub:latest').pull()
                    docker.image('selenium/node-chrome:latest').pull()
                    docker.image('selenium/node-firefox:latest').pull()
                }
            }
        }

        stage('Run Tests') {
            steps {
                // Your existing pipeline stages
                // Checkout Git repository
                git branch: 'main', url: 'https://github.com/shohel677/selenium-docker.git'

                // Start Selenium Grid containers
                script {
                    docker.run("-d", "--name selenium-hub", "selenium/hub:latest")
                    docker.run("-d", "--name selenium-node-chrome", "--link selenium-hub:hub", "selenium/node-chrome:latest")
                    docker.run("-d", "--name selenium-node-firefox", "--link selenium-hub:hub", "selenium/node-firefox:latest")
                }

                // Run Selenium tests with specified Maven command
                sh "${mvnHome}/bin/mvn clean test -Dbrowser=chrome -DsuiteFile=suites/user_registration.xml -Dplatform=linux"

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
