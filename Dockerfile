FROM tomcat:jdk11-adoptopenjdk-hotspot
COPY /target/monitoring-api-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/monitoring-api.war
EXPOSE 8080 8888
