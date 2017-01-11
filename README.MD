##Spring Boot demo

This is Sample spring boot application which uses fabric8-maven-plugin to deploy on Kuberenetes/Openshift.

#####Maven Goal:
```

mvn clean install fabric8:build fabric8:deploy -Dfabric8.mode=openshift -Dfabric8.build.strategy=s2i

```

#####ConfigMap:
```
apiVersion: v1
kind: ConfigMap
metadata:
  name: spring-boot-demo
data:
  application.yaml: |-
    message:
      name: Cloud
```      

#####Secrets:
```
apiVersion: v1
kind: Secret
metadata:
  name: spring-boot-demo
data: { 
    "username": "dmFsdWUtMQ0K",
    "password": "dmFsdWUtMg0KDQo="
    }
```

#####BootStrap propeties to enable spring-cloud-kubernetes
```

spring.application.name=spring-boot-demo
spring.cloud.kubernetes.enabled=true
spring.cloud.kubernetes.secrets.enableApi=true
spring.cloud.kubernetes.config.namespace=cip-ms
message.name=Local

```