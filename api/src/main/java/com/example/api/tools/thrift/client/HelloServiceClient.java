package com.example.api.tools.thrift.client;

import com.example.api.tools.thrift.service.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class HelloServiceClient {

//    public static void main(String[] args) {
//        System.out.println("客户端启动....");
//        try (TTransport transport = new TSocket("localhost", 9898, 30000)) {
//            // 协议要和服务端一致
//            TProtocol protocol = new TBinaryProtocol(transport);
//            Hello.Client client = new Hello.Client(protocol);
//            transport.open();
//            String result = client.helloString("哈哈哈");
//            System.out.println(result);
//        } catch (TException e) {
//            e.printStackTrace();
//        }
//    }
}
