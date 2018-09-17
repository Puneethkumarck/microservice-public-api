# Microservice-public-api

[![Build Status](https://travis-ci.org/Puneethkumarck/microservice-public-api.svg?branch=master)](https://travis-ci.org/Puneethkumarck/microservice-public-api)

Building microservice using publicly hosted API

This Application demonstrates the microservice implementation using Spring cloud and Netflix OSS stack and docker .

There are six Spring Boot Apps , implmented in a diff programming languages to show advantages of building micro services.


## eureka-server

  Which is Service registration and discovery service using Spring cloud netflix Eureka.
  
```
  	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-netflix-eureka-server</artifactId>
		</dependency>
```

  ![Settings Window](https://raw.github.com/Puneethkumarck/microservice-public-api/master/screenshots/eureka_registration.png)
    
## config-server.

Which is git backed Config server , to keep separate the property file from actual app , to support the 12 Factor App  Architecture style to implement the microservices . This App talks to config stored in git repo in runtime to resolve the properties for microservices. Which uses the spring security dependecy to decrypt the encrypted properties stored in config repo . Encrypted property should be prefixed with {cipher} , for spring security to decrypt the respective values.
 
 
 ```
 	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
		</dependency>
    
    	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```


## edge service
Zuul is a JVM based router and server side load balancer by Netflix.It provides a single entry to our system, which allows a browser, mobile app,or other user interface to consume services from multiple hosts without managing cross-originresource sharing (CORS) and authentication for each one. We can integrate Zuul with other Netflix projects like Hystrix for fault tolerance and Eureka for service discovery, or use it to manage routing rules,filters, and load balancing across your system.

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>

```

```
zuul:
  ignored-services: '*'
  ignoredPatterns: /**/api/**
  routes:
    github:
       path: /github/**
       serviceId: github-api
    youtube:
          path: /youtube/**
          serviceId: youtube-api
    youtube-api-kotlin:
          path: /yk/**
          serviceId: youtube-api-kotlin
```

Above yml routes config is responsible for microservice routing , serviceId refers to microservice name/application name which is registered with eureka server , above mapping guides all the request from the user which contains /github/** to github-api microservice which is registered with eureka and respective endpoints , same applies for other mappings shown above.


## github-api


which is an microservice implemented using groovy as an programming language . Which is performing HTTP GET operations for    GITHUB endpoints . Below dependecies required to resolve the properties to talk to config server and register with eureka

```
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
		</dependency>
  ```
  ## youtube-api 
  
  which is an microservice implemented using groovy as an programming language . Which is performing HTTP GET operations for     YOUTUBE endpoints .which registeres with eureka server and calls config server to resolve the properties @ runtime.
  
 ## youtube-api-kotlin
  
  which is same as youtube api , but implemeted using kotlin.
  
  
  # Run
  
  * JAVA 
  * Groovy
  * Kotlin
  * Docker Tool box
  * Docker compose
  * Kitematic
  * Mvn
  * Intelli j idea
  * Groovy-Spock Unit Testing
  
  
  
  
  clone the git repo to your local [https://github.com/Puneethkumarck/microservice-public-api.git] , Make sure docker is running in your   machine before building project
  
  run below mvn command in root pom
  
  ```
  mvn clean install -DskipTests=true -Ddocker.skip=false
  ```
  
  Which will build the respective JAR and docker images . Later run the docker compose command spin up th docker contaniers
  
  ```
  docker-compose up
  ```
  
 # Windows Users:
  perform the mvn command in docker terminal , since docker image build is enabled using pom using spotify plugin , if we try execute from     other terminals will face below issue,since plugin failed to connect docker host
  ```
  [ERROR] Failed to execute goal com.spotify:docker-maven-plugin:0.4.5:build (server) on project web-service: Exception caught: java.util.concurrent.ExecutionException: com.spotify.docker.client.shaded.javax.ws.rs.ProcessingException: org.apache.http.conn.HttpHostConnectException: Connect to localhost:2375 [localhost/127.0.0.1, localhost/0:0:0:0:0:0:0:1, localhost/fe80:0:0:0:0:0:0:1%1] failed: Connection refused ->
  ```
  
  # Screen shots
  
  * Building docker image for single project
  
  ![Settings Window](https://raw.github.com/Puneethkumarck/microservice-public-api/master/screenshots/building_eureka_server.png)
 
  * pushing docker image to docker hub repo 
  
    > Note: Make sure your image name prefix with your exact username of docker hub , other wise push will fail.
  
  ![Settings Window](https://raw.github.com/Puneethkumarck/microservice-public-api/master/screenshots/publish_to_docker_hub.jpg)
  
  * Intelij docker config
   ![Settings Window](https://raw.github.com/Puneethkumarck/microservice-public-api/master/screenshots/docker_config_Intellij.jpg)
   
   * docker image info
    ![Settings Window](https://raw.github.com/Puneethkumarck/microservice-public-api/master/screenshots/docker_config_Intellij2.jpg)
  
  * docker contanier Info
   ![Settings Window](https://raw.github.com/Puneethkumarck/microservice-public-api/master/screenshots/docker_config_Intellij3.jpg)
   
   # Useful docker commands to run throgh this project
```
   docker -v (to check docker version installed on machine)
   docker image build --rm=true  ( to build an image)
   docker image pull ${IMAGE ID} (to pull docker image from docker hub registry)
   docker image ls (list all images available in local docker machine)
   docker image prune (removes all dangling images locally)
   docker image rm ${IMAGE_ID} (remove an image from local dcoker machine)
   docker container run (startup the contanier)
   docker container ls (list all the contanier)
   docker container rm ${contanier_id} (remove contanier)
   
  ```
    
  # Useful links
  
  * spotify Maven plugin info
  
  (https://forums.docker.com/t/spotify-docker-maven-plugin-cant-connect-to-localhost-2375/9093)
  (https://forums.docker.com/t/spotify-docker-maven-plugin-cant-connect-to-localhost-2375/9093/6)
  
  * Working with docker inside intellij
  (https://www.jetbrains.com/help/idea/docker.html)
  
