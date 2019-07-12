FROM openjdk:8-jdk-alpine

RUN apk --no-cache add git && git clone https://github.com/yt8492/KtorHelloWorld --depth 1 -b v1.0.7

WORKDIR /KtorHelloWorld
RUN chmod +x ./gradlew && chmod +x ./run.sh
ENTRYPOINT ["sh", "./run.sh"]