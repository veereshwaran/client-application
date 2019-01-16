# Spring OAuth2 Client Application
This is a simple applcation for illustrating Spring oauth2 workflow

### Requirement
  - Redis (To run redis docker container use this command - "docker run --name redis -p 6379:6379 -d redis")
  - Single Sign On Server (To run simple SSO server refer project - https://github.com/veereshwaran/sso-server)
  - Spring-boot-cli (To install spring-boot-cli refer - https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html)

Note: By changing oauth2 server configuration in application.yml, you can connect your own SSO server

### Step to run this Application

Use below command to run this application

`~/spring-boot-cli-2.1.1.RELEASE-bin/bin/spring run app.groovy`
