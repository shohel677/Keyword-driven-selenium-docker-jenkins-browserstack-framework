pipeline {
    agent {
        label 'jenkins-agent'
    }

    triggers {
        cron('0 0 * * *')
    }

    environment {
        // Define Maven and Java installations
        mvnHome = tool 'Maven'
        javaHome = tool 'Java'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout Maven Selenium Java project from Git
                git branch: 'main', url: 'https://github.com/shohel677/selenium-docker.git'
            }
        }

        stage('Build') {
            steps {
                // Build Maven project
                sh "${mvnHome}/bin/mvn clean install"
            }
        }

        stage('Test') {
            steps {
                // Run Selenium tests
                sh "${mvnHome}/bin/mvn clean test -Dbrowser=chrome -DsuiteFile=suites/user_registration.xml -Dplatform=linux -DhubUrl=http://localhost:4444/wd/hub"
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

    // Post-build configuration
    post {
        always {
            // Clean workspace
            cleanWs()
        }
    }
}
