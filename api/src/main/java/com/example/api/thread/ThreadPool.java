package com.example.api.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ExecutorService 中的submit是带返回值的，execute是不带返回值的
 */
@Slf4j
public class ThreadPool {
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService pool = new ThreadPoolExecutor(2, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(3));
//        AtomicInteger integer = new AtomicInteger(0);
//        AtomicInteger integer1 = new AtomicInteger(0);
//        integer.intValue();
//        CountDownLatch latch = new CountDownLatch(10);
//        ConcurrentHashMap<String, Integer> res = new ConcurrentHashMap<>();
//        List<String> strings = new ArrayList<>();
//        strings.add("zuo");
//        strings.add("yuan");
//        strings.add("xun");
//        strings.add("xun1");
//        strings.add("xun2");
//        strings.add("xun3");
//        strings.add("xun4");
//        strings.add("xun5");
//        strings.add("xun6");
//        strings.add("xun7");
//        for (String s:strings) {
//            pool.submit(() -> {
//                log.info("index,{}", integer1.incrementAndGet());
//                res.put("test" + s, 1);
//                latch.countDown();//应该在所有内容执行之后
//            }, res);
//        }
//        latch.await();
//        pool.shutdown();
//        log.info("回到主线程之后");
//        for (String key : res.keySet()) {
//            System.out.println(key + "  " + res.get(key));
//        }
//    }
}
