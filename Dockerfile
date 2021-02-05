From openjdk:8
copy ./build/libs/weather-api-0.0.1-SNAPSHOT.jar weather-api-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","weather-api-0.0.1-SNAPSHOT.jar"]