def call(String imageName) {

    script {

        withCredentials([usernamePassword(
            credentialsId: 'docker-id',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {

            sh """
            docker build -t \$DOCKER_USER/${imageName}:latest .

            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin

            docker push \$DOCKER_USER/${imageName}:latest
            """

        }

    }

}
