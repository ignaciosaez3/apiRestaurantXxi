FROM azul/zulu-openjdk-alpine:11-latest
ADD build/libs/API-RestaurantXXI-0.0.1-SNAPSHOT.jar app/app.jar
WORKDIR app
ENTRYPOINT ["java","-jar","app.jar"]