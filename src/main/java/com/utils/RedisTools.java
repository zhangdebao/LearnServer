package com.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

@Component
public class RedisTools {

    private static int DefaultTime = 0;
    private  static JedisPool pool = null;

    static {
        try {
            Resource resource = new ClassPathResource("application.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            DefaultTime = Integer.valueOf(props.getProperty("spring.redis.timeout"));
            pool = new JedisPool(new JedisPoolConfig(), props.getProperty("spring.redis.host"), Integer.parseInt(props.getProperty("spring.redis.port")));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
    public static Jedis getJedis () {
        Jedis jedis = pool.getResource();
        return  jedis;
    }
    public static String addValue (String key,String value) {
        String result = getJedis().set(key, value);
        return  result;
    }
    public static String getValue (String key) {
        return getJedis().get(key);
    }
}
