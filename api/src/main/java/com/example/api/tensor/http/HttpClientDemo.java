package com.example.api.tensor.http;

import com.example.api.constants.FtpParam;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientDemo {
    public static String get(String s, String userName) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet("http://10.103.238.102:5000?url=" + s);
        HttpGet httpGet = new HttpGet(FtpParam.tenHost + "?url=" + s + "&userName=" + userName);
        CloseableHttpResponse httpResponse = null;
        String res = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity responseEntity = httpResponse.getEntity();
            System.out.println("响应状态：" + httpResponse.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为：" + responseEntity.getContentLength());
//                System.out.println("相应内容为：" + EntityUtils.toString(responseEntity));
                res = EntityUtils.toString(responseEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
