# Payara full server

This docker image contains the Payara full application server with some extra's.

* Payara full application server
* JDBC driver for MySQL
* ConnectionPool configured for MySQL Quote database
* jdbc/quote_db configured for MySQL Quote table

## Build

from the `docker-images` folder run:

* for local build

```bash
make payara-full-jndi-quote
```

* for release

```bash
make release-payara-full-jndi-quote
```

Don't forget to edit the `makefile.env` to set the correct values for your release


# Usage

This image should be used as a base image for a thin war project needing a Quote db

```Dockerfile
FROM ivonet/payara-full-jndi-quote:1.0

COPY myapplication.war $DEPLOY_DIR
```

Then build this image.
