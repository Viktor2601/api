# Build
mvn clean package && docker build -t it.viktor/Segnalibri .

# RUN

docker rm -f Segnalibri || true && docker run -d -p 8080:8080 -p 4848:4848 --name Segnalibri it.viktor/Segnalibri 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test