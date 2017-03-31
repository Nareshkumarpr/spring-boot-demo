#!/usr/bin/env groovy
   def mvnHome
   stage('PREPARE') {
      node {
            git 'https://github.com/Nareshkumarpr/spring-boot-demo.git'
            mvnHome = tool 'maven'
            }
   }
   stage('BUILD') {
       node {
             sh "'${mvnHome}/bin/mvn' clean install -Dmaven.test.skip=true"
             }
   }
   stage('TEST') {
       node {
             sh "'${mvnHome}/bin/mvn' test"
             }
   }
   stage('DEPLOY TO DEV') {
       node {
             sh "'${mvnHome}/bin/mvn' fabric8:build fabric8:deploy -Dfabric8.mode=openshift -Dfabric8.namespace=dev"
             }
   }
   stage('DEPLOY TO SIT') {
           timeout(time:5, unit:'DAYS') {
               input message:'SURE TO PROMOTE TO SIT?', submitter: 'it-ops'
           }
          node {
                sh "'${mvnHome}/bin/mvn' fabric8:build fabric8:deploy -Dfabric8.mode=openshift -Dfabric8.namespace=sit"
                }
      }