package com.buge.event;

import com.buge.B;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: yachen.shen
 * @Date 2020/3/21 12:25
 */
public class AddBean {

	@Autowired
	private B b;

	public void add() {
		System.out.println("add");
		System.out.println(b);
	}
}
