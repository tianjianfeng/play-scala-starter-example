#FROM openjdk:8-jre-alpine
FROM hseeberger/scala-sbt

ARG GIT_COMMIT=not_available

RUN mkdir -p /root/app
WORKDIR /root/app

COPY . ./

RUN sbt assembly \
  && mv target/scala-2.12/app-assembly.jar ./

ENTRYPOINT ["java", "-Dgit_commit=GIT_COMMIT", "-jar", "./app-assembly.jar"]
