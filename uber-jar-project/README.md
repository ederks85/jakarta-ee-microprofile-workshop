# uber-jar-project

This project contains a Jakarta EE 8 application that retrieves "Quote of the day" instances from a backend server via HTTP, using MicroProfile RestClient.

## Development

### Docker Image
You can build and deploy a new version of the application on a Docker image in order to run and ship it.

```bash
mvn clean install
``` 
```bash
docker build -t uber-jar-project .
``` 

### Run Locally
```bash
docker run --rm -p 7070:8080 uber-jar-project
``` 

## Notes
- `mvn clean install` is necessary to create the Uber JAR, since the `mvn payara-micro:bundle` goal is attached to the `install` lifecycle phase.
- This approach does not allow redeploys of the app due to the app and server being merged in the UberJAR!