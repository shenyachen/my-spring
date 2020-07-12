package com.buge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/2/10 17:55
 */
@Component
public class CircleA {
	@Autowired
	private CircleB b;

	public CircleA() {
		System.out.println("CircleA");
	}
}
