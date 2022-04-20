#!/bin/sh
mvn clean package && docker build -t it.viktor/World .
docker rm -f World || true && docker run -d -p 8080:8080 -p 4848:4848 --name World it.viktor/World 
