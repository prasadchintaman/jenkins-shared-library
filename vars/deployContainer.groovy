def call(String containerName, String imageName) {

    sh """
    docker stop ${containerName} || true
    docker rm ${containerName} || true
    docker run -d -p 5000:5000 --name ${containerName} prasad1993/${imageName}
    """
}
