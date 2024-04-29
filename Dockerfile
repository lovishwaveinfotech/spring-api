FROM openjdk:19-jdk
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/journal-0.0.1-SNAPSHOT-plain.jar"]
EXPOSE 8080