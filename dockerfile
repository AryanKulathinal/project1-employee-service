FROM openjdk:17-oracle
COPY ./target/emp-service-0.0.1-SNAPSHOT.jar employee-service.jar
CMD ["java","-jar","employee-service.jar"]