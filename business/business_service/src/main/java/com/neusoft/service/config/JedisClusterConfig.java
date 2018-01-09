package com.neusoft.service.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * 生成JedisCluster对象
 * 
 * */
/**
 * 
 * 开启SpringSession支持
 * @EnableRedisHttpSession
 * */
@Configuration
/*@EnableRedisHttpSession*/
public class JedisClusterConfig {  
  
    @Autowired  
    private RedisClusterProperties redisProperties;  
  
    /**  
     * 注意：  
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用  
     * @return  
     */  
    @Bean  
    public JedisCluster getJedisCluster() {  
        String[] serverArray = redisProperties.getNodes().split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)  
        Set<HostAndPort> nodes = new HashSet<>();  
        for (String ipPort : serverArray) {  
            String[] ipPortPair = ipPort.split(":");  
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));  
        }  
        return new JedisCluster(nodes, redisProperties.getTimeout(),redisProperties.getMaxAttempts());  
    }
    @Bean  
    public JedisConnectionFactory connectionFactory() {  
            return new JedisConnectionFactory();   
    } 
  
}  
