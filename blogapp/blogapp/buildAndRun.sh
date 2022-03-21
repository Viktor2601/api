#!/bin/sh
mvn clean package && docker build -t it.viktor/blogapp .
docker rm -f blogapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name blogapp it.viktor/blogapp 
