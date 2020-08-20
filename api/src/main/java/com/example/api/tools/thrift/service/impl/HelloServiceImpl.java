package com.example.api.tools.thrift.service.impl;

import com.example.api.tools.thrift.service.Hello;
import org.apache.thrift.TException;

public class HelloServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return "hello" + para;
    }
}
