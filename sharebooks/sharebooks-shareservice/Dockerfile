
FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER tianjiqx "quxingyy@126.com"
VOLUME /tmp
ADD ./target/sharebooks-shareservice-0.0.1-SNAPSHOT.jar /app/sharebooks-shareservice-app.jar
#RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/sharebooks-shareservice-app.jar"]

EXPOSE 9501


