# hollow-jar-project

This project contains a Jakarta EE 8 application that retrieves "Quote of the day" instances from a backend server via HTTP, using MicroProfile RestClient.

## Docker Image
You can build and deploy a new version of the application on a Docker image in order to ship it.
```bash
mvn clean verify
``` 
```bash
docker build -t hollow-jar-project .
``` 

## Development
In order to develop the application, you can run it in a locally using a dedicated Payara Micro 5.193 server:
```bash
java -jar /absolute/path/to/payara-micro-5.193.jar --port 9090 --deploy target/hollow-jar-project.war
```

...or mount the application locally in a Docker container:
```bash
docker run --rm -p 9090:8080 -v /absolute/path/to/hollow-jar-project/target/:/opt/payara/deployments payara/micro:5.193
```

## Notes
- Since Payara isn't currently providing a `payara/micro` Docker image with a Java version greater than Java 8, we have to compile explicitly to Java 8.
