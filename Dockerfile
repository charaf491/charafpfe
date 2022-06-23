# For Java 11, try this
FROM openjdk:11 as build

#Refer to Maven build -> finalName
ARG JAR_FILE=target/charafpfe.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/charafpfe.jar /opt/app/charafpfe.jar
COPY ${JAR_FILE} charafpfe.jar

# java -jar /opt/app/charafpfe.jar
ENTRYPOINT ["java","-jar","charafpfe.jar"]