package com.buge.event;

import com.buge.*;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yachen.shen
 * @Date 2020/2/3 12:34
 */
public class Boot {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Config.class);
		ac.refresh();
		Buge666 bean = (Buge666)ac.getBean("666");
		bean.event666();

		AddBean addBean = bean.addBean(AddBean.class);
		addBean.add();



		System.out.println(ac.getBean("AddBean"));

		ac.getAutowireCapableBeanFactory().destroyBean(addBean);
		System.out.println(ac.getBean(AddBean.class));

	}
}
