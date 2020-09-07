package com.example.api.thread;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;


import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.annotation.Nullable;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public class FutureDemo {
    public void thread() throws InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(2, 10, 0L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(3));
        List<String> strings = new ArrayList<>();
        strings.add("zuo");
        strings.add("yuan");
        strings.add("xun");
        Map<String, List<String>> map = new HashMap<>();
        CountDownLatch latch = new CountDownLatch(strings.size());
        // MoreExecutors.listeningDecorator：将一个普通的线程池包装成一个含通知功能的Future线程池
        ListeningExecutorService service = MoreExecutors.listeningDecorator(pool);
        for (String s : strings) {
            // 将任务提交到线程池并得到ListenableFuture
            ListenableFuture<List<String>> future = service.submit(() -> getStrings(s));
            // 增加了异常处理
            Futures.addCallback(future, new FutureCallback<List<String>>() {
                @Override
                public void onSuccess(@Nullable List<String> result) {
                    System.out.println("异步处理成功，result=" + result);
                    map.put(s, result);
                    try {
                        System.out.println("异步处理成功:");
                        latch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(Throwable t) {
                    System.out.println("异步处理失败，t=" + t);
                }
            }, MoreExecutors.newDirectExecutorService());
        }
        latch.await();
//        service.shutdown();
        System.out.println("asa");
        System.out.println("asa");
        System.out.println("asa");
        System.out.println("asa");
        System.out.println("asa");
        System.out.println("asa");
    }

    private List<String> getStrings(String s) throws InterruptedException {
        List<String> sb = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sb.add(s);
            log.info("para,{}", s);
            Thread.sleep(100);
        }
        return sb;
    }
}
