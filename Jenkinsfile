pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/lballetti/post-education.git'

                // Run Maven on a Unix agent.
                sh "mvn clean -Dbrowser=firefox -Dsuite=testng -Dcapabilities.enableVideo=true -Dcapabilities.enableVNC=true -DbrowserVersion=116 -Dselenium_url=http://test:test-password@localhost:4444/wd/hub test"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts '**/target/surefire-reports/First Suite/*.html'
                }
            }
        }
    }
}