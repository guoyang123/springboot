package com.neusoft.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect  //定义日志切面类
public class LogAspect {

	 //定义切点
	@Pointcut("execution(* com.neusoft.service..*.*(..))")
	public void executionService() {}
	
	//前置通知
	@Before("executionService()")
	public void doBeforeAdvice(JoinPoint jp) {
		System.out.println("我是前置通知...");
		//获取目标方法的参数信息
        Object[] args=jp.getArgs();
        //aop代理类的信息
        Object _this=jp.getThis();
        //代理目标对象
        Object _target=jp.getTarget();
        //通知的签名
        Signature singture=jp.getSignature();
        
        //代理的是哪一个方法
        System.out.println(singture.getName());
        //aop代理类的的名字
        System.out.println(singture.getDeclaringTypeName());
        //aop代理类的信息
        Class _cls=singture.getDeclaringType();
    
	}
	
	
	/**
	 * 后置通知
	 * 这里需要注意的是: 
	 *      如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息 
	 *      如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数 
	 * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值 
	 * @param joinPoint 
	 * @param keys 
	 * 
	 * */
	@AfterReturning("execution(* com.neusoft.service..*.*(..))")
	public void doAfterReturningAdvice(JoinPoint jp) {
		
		System.out.println("运行了后置通知..返回值为:");
		
	}
	
	/**
	 * 后置通知
	 * */
	@After("execution(* com.neusoft.service..*.*(..))")
	public void doAfterAdvice(JoinPoint jp) {
		System.out.println("运行了后置通知finish..");
	}
	
	
}
