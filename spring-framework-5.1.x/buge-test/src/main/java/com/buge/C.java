package com.buge;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/2/3 15:46
 *
 * 三、在扫描、解析class->beanDefinition之后，执行此回调
 * 如下，可修改已经解析的beanDefinition,打到偷梁换柱的效果
 */
@Component
public class C implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanFactory.getBeanDefinition("b");
		//beanDefinition.setBeanClass(C.class);
		/**
		 * //Map<String, Object> attributes = new LinkedHashMap<>();
		 * 存放beanDifinition的元数据、我们自己扩展的类信息、额外信息
		 */
		beanDefinition.setAttribute("xxx",  "xxx");
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		/**
		 * BeanMetadataElement接口的实现
		 * class的元（文件）
		 */
		System.out.println(beanDefinition.getResource());
	}
}
