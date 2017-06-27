此项目是一个给予spring cloud的项目demo。
完整部署好的docker镜像获取方式为: docker pull tianjiqx/sharebooks

本项目实际尚未完全完成，缺少部分ui界面接口，可以在chrome上安装postman，生成url请求。url地址生成，可以参考文档中的例子，以及bookservice和shareservice目录下的controller的代码。注意若连接路由模块端口8080，需要/book/book/books比代码中的url多一个前缀。

本项目所主要参考的资料有：

《第一本Docker书》

《项目管理利器——maven》
http://www.imooc.com/learn/443

《2小时学会SpringBoot》
http://www.imooc.com/learn/767

《第一个docker化的java应用》
http://www.imooc.com/learn/824


《JavaEE开发的颠覆者 Spring Boot实战》

《Spring Cloud微服务实战》

《史上最简单的 Spring Cloud 教程》
http://blog.csdn.net/column/details/15197.html


-----------
补充：
另外将各个模块拆分安装构建方式如下

//构建docker镜像

docker rm -f some-sharebooks-eurekaservice 
docker rmi tianjiqx/sharebooks-eurekaservice
docker build -t tianjiqx/sharebooks-eurekaservice  ./sharebooks-eurekaservice

docker rm -f some-sharebooks-configservice 
docker rmi tianjiqx/sharebooks-configservice
docker build -t tianjiqx/sharebooks-configservice  ./sharebooks-configservice

docker rm -f some-sharebooks-bookservice 
docker rmi tianjiqx/sharebooks-bookservice
docker build -t tianjiqx/sharebooks-bookservice  ./sharebooks-bookservice

docker rm -f some-sharebooks-shareservice 
docker rmi tianjiqx/sharebooks-shareservice
docker build -t tianjiqx/sharebooks-shareservice  ./sharebooks-shareservice

docker rm -f some-sharebooks-feginservice 
docker rmi tianjiqx/sharebooks-feginservice
docker build -t tianjiqx/sharebooks-feginservice  ./sharebooks-feginservice

docker rm -f some-sharebooks-ribbonservice 
docker rmi tianjiqx/sharebooks-ribbonservice
docker build -t tianjiqx/sharebooks-ribbonservice  ./sharebooks-ribbonservice

docker rm -f some-sharebooks-zuulservice
docker rmi tianjiqx/sharebooks-zuulservice
docker build -t tianjiqx/sharebooks-zuulservice  ./sharebooks-zuulservice


//启动容器/
docker run --name some-sharebooks-eurekaservice -p 8761:8761   -d tianjiqx/sharebooks-eurekaservice
docker run --name some-sharebooks-configservice -p  8888:8888 --link some-sharebooks-eurekaservice:sharebooks-eurekaservice -d tianjiqx/sharebooks-configservice

docker run --name some-sharebooks-bookservice -p 9001:9001 --link some-mysql:dbmysql --link some-sharebooks-eurekaservice:sharebooks-eurekaservice -d tianjiqx/sharebooks-bookservice
docker run --name some-sharebooks-shareservice  -p 9501:9501 --link some-mysql:dbmysql --link some-sharebooks-eurekaservice:sharebooks-eurekaservice -d tianjiqx/sharebooks-shareservice

docker run --name some-sharebooks-feginservice -p 8765:8765 --link some-sharebooks-shareservice:sharebooks-shareservice --link some-sharebooks-eurekaservice:sharebooks-eurekaservice  -d tianjiqx/sharebooks-feginservice
docker run --name some-sharebooks-ribbonservice -p 8764:8764 --link  some-sharebooks-bookservice:sharebooks-bookservice --link some-sharebooks-eurekaservice:sharebooks-eurekaservice -d tianjiqx/sharebooks-ribbonservice
docker run --name some-sharebooks-zuulservice -p 8080:8080 --link some-sharebooks-ribbonservice:sharebooks-ribbonservice --link some-sharebooks-feginservice:sharebooks-feginservice --link some-sharebooks-eurekaservice:sharebooks-eurekaservice -d tianjiqx/sharebooks-zuulservice



//停止容器
docker stop some-sharebooks-eurekaservice 
docker stop some-sharebooks-configservice 
docker stop some-sharebooks-bookservice 
docker stop some-sharebooks-shareservice 
docker stop some-sharebooks-feginservice 
docker stop some-sharebooks-ribbonservice 
docker stop some-sharebooks-zuulservice 


//清理所有容器
docker rm -f some-sharebooks-eurekaservice 
docker rm -f some-sharebooks-configservice 
docker rm -f some-sharebooks-bookservice 
docker rm -f some-sharebooks-shareservice 
docker rm -f some-sharebooks-feginservice 
docker rm -f some-sharebooks-ribbonservice 
docker rm -f some-sharebooks-zuulservice
//////////////////////////////////////////////////
//dcoker hub 镜像拉取
docker pull tianjiqx/sharebooks-eurekaservice
docker pull tianjiqx/sharebooks-configservice
docker pull tianjiqx/sharebooks-bookservice
docker pull tianjiqx/sharebooks-shareservice
docker pull tianjiqx/sharebooks-feginservice
docker pull tianjiqx/sharebooks-ribbonservice
docker pull tianjiqx/sharebooks-zuulservice

//启动容器
启动方式类似，只是需要注意先启动mysql数据库，见《sharebooks设计文档》中启动的第一阶段

在数据库服务准备好之后，第二阶段按上的命名启动sharebooks-eurekaservice 、sharebooks-configservice等微服务


