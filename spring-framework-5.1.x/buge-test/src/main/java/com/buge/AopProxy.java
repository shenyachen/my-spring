package com.buge;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/2/12 23:51
 */
@Component
@Aspect
public class AopProxy {

	@Pointcut("execution(* com.buge.Targer.*(..))")
	public void a() {}

	@Before("a()")
	public void after() {
		System.err.println("proxy");
	}
}
