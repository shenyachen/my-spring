package com.buge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/2/3 12:33
 */
@Component
@Scope(proxyMode = ScopedProxyMode.NO)
public class A {
	@Autowired
	public C b;

	public A() {
		System.out.println("====A init====");
	}

}
