FROM openjdk:17

EXPOSE 8080

ADD target/docker-player-api.jar docker-player-api.jar

ENTRYPOINT ["java", "-jar", "docker-player-api.jar"]