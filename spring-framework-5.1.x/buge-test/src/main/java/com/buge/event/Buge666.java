package com.buge.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/3/21 10:09
 */
@Component("666")
public class Buge666 implements ApplicationContextAware {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private DefaultListableBeanFactory defaultListableBeanFactory;

	public void event666() {
		applicationContext.publishEvent(new MyEvent(this));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * 项目运行过程中，动态添加一个bean
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public <T> T  addBean(Class<T> clazz) {
		T bean = defaultListableBeanFactory.createBean(clazz);
		defaultListableBeanFactory.registerSingleton(clazz.getSimpleName(), bean);
		return bean;
	}
}
