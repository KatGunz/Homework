FROM openjdk:8-jre-alpine
MAINTAINER KatGunz
COPY target/spring-boot-*.war /app.war
ADD . /code
WORKDIR /code
