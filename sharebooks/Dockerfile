FROM laitian912/centos6-java8:8u66
#FROM pulsepointinc/centos6-java8
MAINTAINER tianjiqx "quxingyy@126.com"
VOLUME /tmp

RUN wget --no-check-certificate https://bootstrap.pypa.io/ez_setup.py -O - |  python

RUN easy_install supervisor

#RUN yum install supervisor -y supervisor
RUN mkdir -p /var/log/supervisor
ADD supervisord.conf /etc/supervisord.conf
#apt-get java:8 无法安装supervisor

RUN mkdir /app
ADD ./sharebooks-bookservice/target/sharebooks-bookservice-0.0.1-SNAPSHOT.jar /app/sharebooks-bookservice-app.jar
ADD ./sharebooks-configservice/target/sharebooks-configservice-0.0.1-SNAPSHOT.jar /app/sharebooks-configservice-app.jar
ADD ./sharebooks-eurekaservice/target/sharebooks-eurekaservice-0.0.1-SNAPSHOT.jar /app/sharebooks-eurekaservice-app.jar
ADD ./sharebooks-feginservice/target/sharebooks-feginservice-0.0.1-SNAPSHOT.jar /app/sharebooks-feginservice-app.jar
ADD ./sharebooks-ribbonservice/target/sharebooks-ribbonservice-0.0.1-SNAPSHOT.jar /app/sharebooks-ribbonservice-app.jar
ADD ./sharebooks-shareservice/target/sharebooks-shareservice-0.0.1-SNAPSHOT.jar /app/sharebooks-shareservice-app.jar
ADD ./sharebooks-zuulservice/target/sharebooks-zuulservice-0.0.1-SNAPSHOT.jar /app/sharebooks-zuulservice-app.jar

ADD ./runboot.sh /app/runboot.sh
WORKDIR /app
RUN chmod a+x runboot.sh
RUN chmod a+x sharebooks-bookservice-app.jar
RUN chmod a+x sharebooks-configservice-app.jar
RUN chmod a+x sharebooks-eurekaservice-app.jar
RUN chmod a+x sharebooks-feginservice-app.jar
RUN chmod a+x sharebooks-ribbonservice-app.jar
RUN chmod a+x sharebooks-shareservice-app.jar
RUN chmod a+x sharebooks-zuulservice-app.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/sharebooks-bookservice-app.jar"]

EXPOSE 9001
EXPOSE 8888
EXPOSE 8765
EXPOSE 8764
EXPOSE 8761
EXPOSE 9501
EXPOSE 8080

CMD ["/usr/bin/supervisord"]

#CMD sh /app/runboot.sh