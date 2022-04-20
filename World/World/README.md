# Build
mvn clean package && docker build -t it.viktor/World .

# RUN

docker rm -f World || true && docker run -d -p 8080:8080 -p 4848:4848 --name World it.viktor/World 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test