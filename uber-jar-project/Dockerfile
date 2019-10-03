FROM openjdk:11.0.4-jre-slim

COPY ./target/uber-jar-project-microbundle.jar /application.jar

EXPOSE 8080
CMD ["/usr/local/openjdk-11/bin/java", "-jar", "/application.jar", "--port", "8080"]
