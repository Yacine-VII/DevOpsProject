FROM openjdk:17-jdk-alpine
EXPOSE 8082
ADD target/alpine-1.0.0.jar alpine-1.0.0.jar
ENTRYPOINT ["java","-jar","/alpine-1.0.0.jar"]