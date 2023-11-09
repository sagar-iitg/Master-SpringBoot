FROM tomcat:9.0.71-jre11-temurin-focal
MAINTAINER SAGAR KUMAR
ENV dbDriver=com.mysql.jdbc.Driver 
ENV dbConnectionUrl=jdbc:mysql://mysqldb-container:3306/collegeapp_db 
ENV dbUserName=root 
ENV dbPassword=root
COPY java-app-with-mysql.war /usr/local/tomcat/webapps
