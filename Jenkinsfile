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
                bat "\"${mvnHome}\\bin\\mvn\" clean install"
            }
        }

        stage('Test') {
            steps {
                // Run Selenium tests
                bat "\"${mvnHome}\\bin\\mvn\" clean test -Dbrowser=chrome -DsuiteFile=suites\\user_registration.xml -Dplatform=windows -DhubUrl=http://localhost:4444/wd/hub"
            }
        }

        stage('Email Report') {
            steps {
                script {
                    // Check if the reports directory exists
                    if (fileExists('reports')) {
                        // Copy report.html from reports folder to workspace
                        bat 'copy reports\\report.html %WORKSPACE%'
                        // Send email with attached test report
                        emailext body: 'Please find attached test report.',
                                 subject: 'Selenium Test Report',
                                 attachmentsPattern: "%WORKSPACE%\\report.html",
                                 to: 'golzarahamedshohel@gmail.com'
                    } else {
                        echo 'Reports directory does not exist.'
                    }
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

def fileExists(String filePath) {
    def file = new File(filePath)
    return file.exists()
}
