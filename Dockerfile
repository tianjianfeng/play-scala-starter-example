#FROM openjdk:8-jre-alpine
FROM hseeberger/scala-sbt

RUN mkdir -p /root/app
WORKDIR /root/app

COPY . ./

RUN sbt assembly \
  && mv target/scala-2.12/app-assembly.jar ./

ENTRYPOINT ["java", "-jar", "./app-assembly.jar"]
