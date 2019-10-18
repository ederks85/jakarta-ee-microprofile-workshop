#!/usr/bin/env bash

kubectl apply -f application-server-project/kubernetes/mysql.yml
kubectl apply -f application-server-project/kubernetes/application-server-project.yml
kubectl apply -f hollow-jar-project/kubernetes/hollow-jar-project.yml
kubectl apply -f uber-jar-project/kubernetes/uber-jar-project.yml
