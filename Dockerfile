FROM openjdk:12
ADD target/parking-lot.jar parking-lot.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "parking-lot.jar"]