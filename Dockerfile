FROM maven:3.8.2-openjdk-11-slim AS build
COPY ./ ./
RUN mvn clean package -DskipTests

#FROM azul:zulu-openjdk-alpine:11
FROM adoptopenjdk:11-jre
COPY ./uploads ./uploads/
COPY --from=build ./target/*jar ./spring.jar

#RUN addgroup -S demo && adduser -S demo -G demo
#USER demo

CMD ["/bin/sh", "-c", "java -jar spring*.jar"]