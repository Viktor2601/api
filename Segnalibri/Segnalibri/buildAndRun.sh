#!/bin/sh
mvn clean package && docker build -t it.viktor/Segnalibri .
docker rm -f Segnalibri || true && docker run -d -p 8080:8080 -p 4848:4848 --name Segnalibri it.viktor/Segnalibri 
