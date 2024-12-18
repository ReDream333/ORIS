FROM maven:3.8.3-openjdk-17 as build

WORKDIR /home/app
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -e

FROM tomcat:9.0.65-jdk17-corretto

WORKDIR /usr/local/tomcat
COPY --from=build /home/app/target/ORIS-1.0-SNAPSHOT.war webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]