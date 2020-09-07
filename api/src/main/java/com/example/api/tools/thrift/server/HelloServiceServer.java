package com.example.api.tools.thrift.server;

import com.example.api.tools.thrift.service.Hello;
import com.example.api.tools.thrift.service.impl.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloServiceServer {
//    public static void main(String[] args) {
//        try {
//            System.out.println("服务端开启....");
//            //Processor负责对客户端的请求做出响应，包括RPC请求转发，调用参数解析和用户逻辑调用，返回值写回等处理。
//            TProcessor tprocessor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
//            // 简单的单线程服务模型
//            //TTransport是与底层数据传输密切相关的传输层，负责以字节流方式接收和发送消息体，不关注是什么数据类型。底层IO负责实际的数据传输，包括socket、文件和压缩数据流
//            TServerSocket serverTransport = new TServerSocket(9898);
//            TServer.Args tArgs = new TServer.Args(serverTransport);
//            tArgs.processor(tprocessor);
//            //TProtocol是用于数据类型解析的，将结构化数据转化为字节流给TTransport进行传输。
//            //TBinaryProtocol 二进制编码格式进行数据传输
//            tArgs.protocolFactory(new TBinaryProtocol.Factory());
//            //TServer主要任务是高效的接受客户端请求，并将请求转发给Processor处理
//            TServer server = new TSimpleServer(tArgs);
//            server.serve();
//        } catch (TTransportException e) {
//            e.printStackTrace();
//        }
//    }
}
