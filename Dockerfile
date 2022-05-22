FROM openjdk:17-alpine

WORKDIR app

COPY target/service-0.0.1-SNAPSHOT.jar shareloc.jar

ENTRYPOINT ["java","-jar","shareloc.jar"]