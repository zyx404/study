package com.example.api.redis;

import com.example.api.tools.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
public class RedisTest {
    public Jedis connectRedis() {
        return RedisUtil.getJedis();
    }

    @Test
    public void redisTest() {
        Jedis jedis = connectRedis();
        jedis.set("zuoyaunxun", "zhaoliyuan");
        System.out.println(jedis.get("zuoyaunxun"));
    }
}
