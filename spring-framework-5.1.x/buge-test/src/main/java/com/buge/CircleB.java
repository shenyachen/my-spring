package com.buge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/2/10 17:56
 */
@Component
public class CircleB {
	@Autowired
	private CircleA a;

	public CircleB() {
		System.out.println("CircleB");
	}
}
