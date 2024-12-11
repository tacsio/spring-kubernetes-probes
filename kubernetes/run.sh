#!bin/sh

cd ..

mvn clean package -DskipTests
docker build -t probe:latest .

cd -

kind create cluster --name dev --config cluster.yaml
kind load docker-image --name dev probes:latest

kubectl apply -f deployment.yml