#!/bin/bash
echo $DB_URL
./gradlew shadowJar
java -jar /KtorHelloWorld/build/libs/KtorHelloWorld-1.0.6-checkbug-all.jar