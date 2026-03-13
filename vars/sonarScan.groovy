def call(String projectKey="flask-app") {
    withSonarQubeEnv('Sonarqube') {
        sh """
        ${tool 'sonar-scanner'}/bin/sonar-scanner \
        -Dsonar.projectKey=${projectKey} \
        -Dsonar.sources=. \
        -Dsonar.host.url=http://34.227.52.130:9000 \
        -Dsonar.login=$SONAR_AUTH_TOKEN
        """
    }
}
