pipeline{

    agent any

    stages{
        stage('Compile stage'){

            steps{
            withMaven(maven : 'apache-maven-3.6.2'){
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Testing stage'){
            steps{
            withMaven(maven : 'apache-maven-3.6.2'){
                    sh 'mvn test'
                }
            }
        }

    }

}