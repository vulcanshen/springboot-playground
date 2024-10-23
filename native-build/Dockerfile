FROM azul/zulu-openjdk-alpine:17-jre-headless-latest

COPY build/libs/native-image-v0.0.0b.jar .

ENTRYPOINT ["java", "-jar", "native-image-v0.0.0b.jar"]