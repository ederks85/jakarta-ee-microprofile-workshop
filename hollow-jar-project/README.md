# hollow-jar-project

This project contains a Jakarta EE 8 application that retrieves "Quote of the day" instances from a backend server via HTTP, using MicroProfile RestClient.

## Docker Image
You can build and deploy a new version of the application on a Docker image in order to ship it.

Go to the [Docker Images](../docker-images) project and run:
```bash
make payara-micro
```
After that, you can use this image to build the app on a Docker image.
```bash
mvn clean verify
``` 
```bash
docker build -t hollow-jar-project .
``` 

## Development
In order to develop the application, you can run it in a local Docker environment which also contains the backend. The application is mounted locally which triggers a redeploy of the application whenever the application changes.
### Run Locally
```bash
docker run --rm -p 9090:9090 -v <<absolute path to folder with hollow-jar-project.war>>:/opt/payara/deployments ivonet/payara-micro --deploy /opt/payara/deployments/hollow-jar-project.war
``` 
### Redeploy WAR
```bash
mvn verify
```

## Notes
- Since Payara isn't currently providing a `payara/micro` Docker image with a Java version greater than Java 8, we have to build one ourselves with similar characteristics to enable the use of Java 11.
