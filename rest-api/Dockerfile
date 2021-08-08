FROM maven:3.8.1-openjdk-11
ADD . /tmp
WORKDIR /tmp
RUN mvn clean package

FROM openjdk:11
MAINTAINER void666@live.com

COPY --from=0 /tmp/target/rest-api.jar /opt/

ENTRYPOINT ["java","-jar","/opt/rest-api.jar","--spring.profiles.active=local"]

EXPOSE 8080