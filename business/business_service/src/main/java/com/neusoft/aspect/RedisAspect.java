package com.neusoft.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neusoft.service.commons.RedisCache;

/**
  * redis切面类
  * */
/*@Component
@Aspect*/
public class RedisAspect {
     @Autowired
	private RedisCache redisCache;
     
    
     
	//定义切入点
 	@Pointcut("execution(* com.neusoft.service.ProductService.findProducts(java.lang.Integer)) and args(productId)")
	public void redisService() {}
	
 	@Around("redisService()")
 	
 	public Object around(ProceedingJoinPoint jp)
 	{
 		Object data=null;
 		//前置，到redis中查询数据
 		System.out.println("从redis中查询数据...");
 		//获取目标方法的参数
 	    Object[] args=	jp.getArgs();
 	    if(args!=null&&args.length>0) {
 	    	//定义redis的key
 	    	 String redisKey=String.valueOf(args[0]); 
 	    	 //从redis缓存中读取数据
 	    	 data= redisCache.getDataFromRedis(redisKey);
 	    	if(data!=null) {
 	    		System.out.println("从redis中查询到了数据...不需要查询数据库");
 	    		return data;
 	    	}
 	    	System.out.println("没有从redis中查询到数据...");
 	    	//从数据库读取数据
 	    	//执行目标方法
 	    	try {
				data=jp.proceed();
				System.out.println("从数据库中查询的数据是=="+data);
				//后置，将查询到的数据插入到数据库
				redisCache.setDataToRedis(redisKey, data);
				//将查询的结果返回
				return data;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	    }
       	
 		return data;
 	}
 	
 	
 	
 	
}
