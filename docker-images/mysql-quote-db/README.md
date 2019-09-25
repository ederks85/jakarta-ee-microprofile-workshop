# Quotes table

This docker images is a specialized MySQL image with a fully initialized 
Quotes database. 

## Build

from the `docker-images` folder run:

* for local build

```bash
make mysql-quote-db
```

* for release

```bash
make release-myqsl-quote-db
```

Don't forget to edit the `makefile.env` to set the correct values for your release

## Usage

To run the database with an editor available just:

* from inside the directory:

```bash
docker-compose up
```

* from docker cli

```bash
docker run -p 3306:3306 ivonet/mysql-quote-db 
```

(the default password for root is `secret`)

