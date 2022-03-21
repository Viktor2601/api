# Build
mvn clean package && docker build -t it.viktor/blogapp .

# RUN

docker rm -f blogapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name blogapp it.viktor/blogapp 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test