FROM openjdk:8-jdk-alpine

RUN apk --no-cache add git && git clone https://github.com/yt8492/KtorHelloWorld

WORKDIR /KtorHelloWorld
RUN chmod +x ./gradlew && chmod +x ./run.sh
ENTRYPOINT ["./run.sh"]