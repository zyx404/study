# study

## 整合mybatis
要在application.properties加上xml的地址

# zookeeper
## maven 依赖：
`        <dependency>
             <groupId>org.apache.zookeeper</groupId>
             <artifactId>zookeeper</artifactId>
             <version>3.6.1</version>
             <!--排除这个slf4j-log4j12-->
             <exclusions>
                 <exclusion>
                     <groupId>org.slf4j</groupId>
                     <artifactId>slf4j-log4j12</artifactId>
                 </exclusion>
             </exclusions>
         </dependency>`
## 问题
### 新版的zookeeper开启会占用8080端口<br>
解决方法:<br>
在conf/zoo.cfg中添加：<br>
admin.serverPort=没有使用的端口
### 要排除zookeeper中的slf4j不然会冲突

