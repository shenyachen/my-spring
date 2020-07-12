package com.buge.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: yachen.shen
 * @Date 2020/3/21 10:06
 */
public class MyEvent extends ApplicationEvent {
	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public MyEvent(Object source) {
		super(source);
	}
}
