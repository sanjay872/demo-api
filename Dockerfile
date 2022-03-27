FROM openjdk:11

ADD target/demo-api-0.0.1-SNAPSHOT.jar demo-api.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","demo-api.jar"]