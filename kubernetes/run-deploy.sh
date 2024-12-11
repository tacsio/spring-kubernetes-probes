#!/bin/sh

cd ..

mvn clean package -DskipTests
docker build -t probes:latest .

cd -

kind load docker-image --name dev probes:latest

kubectl apply -f deployment.yml
