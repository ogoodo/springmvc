### 实现功能
1.文件上传下载
2.表单验证
3.国际化
4.logback日志
5.mysql+MyBatis
6.redis  还需要深入下
定时任务
权限shiro
分库分表
分布式事务
微服务

启动redis
redis-server /usr/local/etc/redis.conf

### 构建项目第一步

Right click on project ---> select "properties" --> Deployement assembly --> "ADD" option --> select "java build path entries" --> select path  --> select Maven Dependencies


### 构建项目第二步
servers/tomcat***/server.xml 设置支持utf-8编码  否则get请求会乱码
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>


### 本地开发调试
1. run > run configurations > new maven build ( 选择workspace, tomcat7:run)
2. run > tomcat7:run
3. open  http://localhost:8080/hi/hello

### 打包发布到tomcat
参考: http://blog.csdn.net/zzq900503/article/details/41249241
1. project->right click->run as->Maven install
2. copy ${project}/target/***.war to ${tomcat}/webapps
3. cd ${tomcat}/bin
4. sh startup.sh
5. open  http://localhost:8080/hi/hello

### 远程部署还没有实验
[maven自动部署到远程tomcat教程]
(http://www.cnblogs.com/xyb930826/p/5725340.html)
[Maven远程Tomcat热部署]
(http://blog.csdn.net/SwingPyzf/article/details/52829792)
mvn tomcat7:deploy 
mvn tomcat7:undeploy 
mvn tomcat7:redeploy

### tools
https://github.com/astarring/mybatis-generator-gui
