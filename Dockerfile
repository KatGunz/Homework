FROM openjdk:8-jre-alpine
MAINTAINER KatGunz
COPY build/libs/demo-*.jar /demo.jar
CMD ["java", "-jar", "/demo.jar"]
