package com.buge;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 * @author: yachen.shen
 * @Date 2020/2/6 20:32
 */
public class BugeRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("==============BugeRegistrar========================");
		CustomScanner customScanner = new CustomScanner(registry);
		customScanner.resetFilters(false);
		customScanner.addIncludeFilter(new AnnotationTypeFilter(Buge.class));
		customScanner.scan("com.buge");

	}
}
