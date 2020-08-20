# study

## 整合mybatis
要在application.properties加上xml的地址

# zookeeper
## maven 依赖：
        <dependency>
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
         </dependency>
         
## 问题
### 新版的zookeeper开启会占用8080端口<br>
解决方法:<br>
在conf/zoo.cfg中添加：<br>
admin.serverPort=没有使用的端口
### 要排除zookeeper中的slf4j不然会冲突

#thrift
![Image text](https://images2015.cnblogs.com/blog/870109/201702/870109-20170221155000163-876398090.png)
thrift是一种c/s的架构体系.在最上层是用户自行实现的业务逻辑代码.第二层是由thrift编译器自动生成的代码，主要用于结构化数据的解析，发送和接收。<br><br>
TServer主要任务是高效的接受客户端请求，并将请求转发给Processor处理。Processor负责对客户端的请求做出响应，包括RPC请求转发，调用参数解析和用户逻辑调用，返回值写回等处理。<br><br>
从TProtocol以下部分是thirft的传输协议和底层I/O通信。TProtocol是用于数据类型解析的，将结构化数据转化为字节流给TTransport进行传输。<br><br>
TTransport是与底层数据传输密切相关的传输层，负责以字节流方式接收和发送消息体，不关注是什么数据类型。底层IO负责实际的数据传输，包括socket、文件和压缩数据流等。

## TProtocol
TBinaryProtocol- 二进制编码格式进行数据传输（默认）<br>
TCompactProtocol- 高效率，密集的二进制编码格式进行数据传输（了解protocol buffer内部编码实现的话，就不足为奇了）<br>
TJSONProtocol - 使用JSON的数据编码协议进行数据传输。<br>
TSimpleJSONProtocol- 只提供JSON只写的协议，使用与通过脚本语言解析<br><br>

# 修改spring启动标志
[修改启动标志](https://blog.csdn.net/wang_lianjie/article/details/103630688)