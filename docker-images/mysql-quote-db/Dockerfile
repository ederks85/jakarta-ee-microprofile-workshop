FROM mysql:5.7.27

ARG PWD
ENV MYSQL_ROOT_PASSWORD ${PWD:-secret}

ADD quote_of_the_day.sql /docker-entrypoint-initdb.d/quote_of_the_day.sql

