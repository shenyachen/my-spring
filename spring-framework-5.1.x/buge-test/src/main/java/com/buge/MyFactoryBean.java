package com.buge;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/2/22 19:25
 */
@Component
public class MyFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new Object();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
}
