package com.neusoft.service.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 集群配置文件
 * 采用javabean的方式配置
 * */
@Configuration  
@EnableAutoConfiguration  
@ConfigurationProperties(prefix = "spring.rediscluster")  
@PropertySource("classpath:redisCluster.properties")
public class RedisClusterProperties {  
  
	/**redis集群节点*/
    private String nodes;
    
     /**连接超时时间*/
    private int timeout; 
    /** 重连次数 */  
    private int maxAttempts;  
      
    @Bean  
    public JedisPoolConfig getRedisConfig(){  
        JedisPoolConfig config = new JedisPoolConfig();  
        return config;  
    }  
   
    public int getTimeout() {  
        return timeout;  
    }  
  
    public void setTimeout(int timeout) {  
        this.timeout = timeout;  
    }

	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}  
    
    
}  