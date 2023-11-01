FROM adoptopenjdk/maven-openjdk11 AS MAVEN_BUILD
MAINTAINER RRFsoftware.es
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} searchcharacter.jar
EXPOSE 3456
ENTRYPOINT ["java","-jar","/searchcharacter.jar"]






