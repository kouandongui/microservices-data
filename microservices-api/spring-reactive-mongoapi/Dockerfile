FROM docker.io/java:8-jre-alpine

# Fix font error on alpine https://bugs.alpinelinux.org/issues/7372
USER root
RUN apk add --no-cache ttf-dejavu fontconfig && rm -rf /var/cache/apk/*
# SET TIMEZONE
RUN apk update
# Change TimeZone

RUN apk add --no-cache tzdata
USER $USER_ID
ENV TZ Europe/Paris
USER $USER_ID
RUN pwd
RUN ls -la
EXPOSE 8080/tcp
ADD target/spring-reative-mongoapi.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]



