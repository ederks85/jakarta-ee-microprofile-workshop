#!/usr/bin/env bash


cd application-server-project
mvn clean verify
docker build -t application-server-project .
cd ../hollow-jar-project
mvn clean verify
docker build -t hollow-jar-project .
cd ../uber-jar-project
mvn clean install
docker build -t uber-jar-project .
cd ..
