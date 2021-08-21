FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8040
ADD target/jpay-java-exercise-0.0.1-SNAPSHOT.jar jpay-java-exercise-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","jpay-java-exercise-0.0.1-SNAPSHOT.jar"]



