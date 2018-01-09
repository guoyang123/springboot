package com.neusoft.service.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 单机版
 * 采用javabean的方式配置
 * */
@Configuration  
@EnableAutoConfiguration  
@ConfigurationProperties(prefix = "spring.redis")  
@PropertySource("classpath:application.properties")
public class RedisConfig {  
  
    
      
    private String hostName;  
  
    private int port;  
  
    private String password;  
  
    private int timeout;  
      
    @Bean  
    public JedisPoolConfig getRedisConfig(){  
        JedisPoolConfig config = new JedisPoolConfig();  
        return config;  
    }  
      
    @Bean  
    public JedisPool getJedisPool(){  
        JedisPoolConfig config = getRedisConfig();  
        JedisPool pool = new JedisPool(config,hostName,port,timeout,password);  
        System.out.println("init JredisPool ...................");  
        return pool;  
    }  
  
    public String getHostName() {  
        return hostName;  
    }  
  
    public void setHostName(String hostName) {  
        this.hostName = hostName;  
    }  
  
    public int getPort() {  
        return port;  
    }  
  
    public void setPort(int port) {  
        this.port = port;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public int getTimeout() {  
        return timeout;  
    }  
  
    public void setTimeout(int timeout) {  
        this.timeout = timeout;  
    }  
}  