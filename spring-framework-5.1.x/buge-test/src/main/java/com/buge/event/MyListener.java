package com.buge.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/3/21 10:07
 */
@Component
public class MyListener /*implements ApplicationListener<MyEvent>*/ {

	//@Override
	@EventListener
	public void onApplicationEvent(MyEvent event) {
		System.out.println("布哥66666666666666666");

	}
}
