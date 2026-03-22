def call(clusterName, region, imageName) {
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-creds']]) {
        sh """
        aws eks update-kubeconfig --region ${region} --name ${clusterName}
        kubectl set image deployment/ecommerce ecommerce=${imageName} --record || true
        kubectl apply -f deployment.yaml
        kubectl apply -f service.yaml
        """
    }
}
