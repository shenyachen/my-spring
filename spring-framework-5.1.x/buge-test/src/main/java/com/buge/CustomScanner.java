package com.buge;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @author: yachen.shen
 * @Date 2020/2/4 15:12
 * 加分项一，结合mybatis的@MapperScan来学习，mybatis源码：ClassPathMapperScanner extends ClassPathBeanDefinitionScanner，重写了
 * isCandidateComponent方法，导致spring可以加载接口,同时在includeFilters添加了一个TypeFilter
 */
public class CustomScanner extends ClassPathBeanDefinitionScanner {
	public CustomScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}
}
