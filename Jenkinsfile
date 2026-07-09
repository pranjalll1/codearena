pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        DOCKER_IMAGE = 'codearena'
        DOCKER_TAG = 'latest'
        DOCKERHUB_REPO = 'pranjalll1/codearena'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '=== Cloning repository ==='
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo '=== Building with Maven ==='
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo '=== Running Unit Tests ==='
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Package') {
            steps {
                echo '=== Creating JAR ==='
                sh 'mvn package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                echo '=== Building Docker Image ==='
                sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
            }
        }
        stage('Docker Push') {
            steps {
                echo '=== Pushing to Docker Hub ==='
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS')]) {
                    sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
                    sh 'docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${DOCKERHUB_REPO}:${DOCKER_TAG}'
                    sh 'docker push ${DOCKERHUB_REPO}:${DOCKER_TAG}'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo '=== Deploying Application ==='
                sh 'docker-compose down || true'
                sh 'docker-compose up -d'
                echo '=== Deployed at port 8081 ==='
            }
        }
    }

    post {
        success { echo '✅ Pipeline completed successfully!' }
        failure { echo '❌ Pipeline failed!' }
    }
}
