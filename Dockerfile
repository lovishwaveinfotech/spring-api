FROM ubuntu
ADD build/libs/*.jar app.jar
COPY --chown=appuser:appuser target/**.jar /home/appuser/app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]