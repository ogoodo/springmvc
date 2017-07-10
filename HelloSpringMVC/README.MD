
### 构建项目第一步

Right click on project ---> select "properties" --> Deployement assembly --> "ADD" option --> select "java build path entries" --> select path  --> select Maven Dependencies


### 构建项目第二步
servers/tomcat***/server.xml 设置支持utf-8编码  否则get请求会乱码
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>

