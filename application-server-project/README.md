# application-server-project

This project contains a Jakarta EE 8 application that retrieves "Quote of the day" instances from a datasource.

## Docker Image
You can build and deploy a new version of the application on a Docker image in order to ship it.
```bash
mvn clean verify
docker build -t application-server-project .
``` 

## Development
In order to develop the application, you can run it in a local Docker environment which also contains the datasource. The application is mounted locally which triggers a redeploy of the application whenever the application changes.
### Run Locally
```bash
docker-compose up
``` 
### Redeploy WAR
```bash
mvn verify
```

## Notes
- `ivonet/payara-full-jndi-quote` is a wrapper around the `payara/server-full` Docker image and in addition provides a datasource definition for connecting to the datasource via the `jdbc/quote_db` identifier.
