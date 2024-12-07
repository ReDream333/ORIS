FROM maven:3.9.9-openjdk-17 as build

COPY src /home/app/src
COPY pom.xml home/app
RUN mvn -f /home/app/pom.xml clean package

FROM tomcat:10.1.29

WORKDIR /usr/local/tomcat
COPY target/ORIS-1.0-SNAPSHOT.war webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]