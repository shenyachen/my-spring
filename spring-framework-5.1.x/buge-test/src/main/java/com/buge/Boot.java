package com.buge;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author: yachen.shen
 * @Date 2020/2/3 12:34
 */
public class Boot {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Config.class);
		// ac.addBeanFactoryPostProcessor();
		GenericBeanDefinition definition = new GenericBeanDefinition();
		//definition.setScope("prototype");
		definition.setBeanClass(B.class);
		/**
		 * 有些definition是abstract的，那这个definition是为了做一个模板使用。
		 * 因为早期的spring创建一个bean是需要手动写beanDefinition的，
		 * 而且抽象类是无法作为spring bean的（抽象类无法实例化），所以需要这个属性，来定义这个definition是否是abstract的。
		 * （如果通过beandefinition的方式去创建一个bean，若这个类是抽象的，不设置这个属性，会报错！！！）
		 * ==作用：ChildBeanDefinition
		 * 作用是为了被继承，属性parentName就是为了指定那个abstract definition,继承他的属性
		 *
		 * //RootBeanDefinition、GenericBeanDefinition、ChildBeanDefinition的区别？
		 * root不能作为子bd(setParentName会报错)，可以描述一个抽象/非抽象的bean信息；
		 * Child只有一个构造方法，必须指定parent。所以他一定是一个子bd;
		 * Generic更加灵活，即可以描述一个抽象/非抽象的bean信息，也可以作为父、子bd
		 *
		 * 当Generic指定了parentName时，spring会进行merge操作，merge后生成一个rootBd!!!
		 *
		 */
		definition.setAbstract(false);
		//definition.setParentName();
		//ac.registerBeanDefinition("b", definition);

		ac.refresh();
		System.out.println(ac.getBean("transactional"));
		System.out.println(ac.getBean("myFactoryBean"));
		System.out.println(ac.getBean("getE"));
		System.out.println(ac.getBean("getF"));
		System.out.println(ac.getBean("getE"));
		System.out.println(ac.getBean("getF"));
		System.out.println(ac.getBeanDefinition("b"));
		System.out.println(ac.getBean("b"));
		System.out.println(ac.getBean("b"));
		//ac.register(A.class);
		System.out.println(ac.getBeanDefinition("a"));
		System.out.println(((A)ac.getBean("a")).b);

		/**
		 * 扩展点：添加自定义TypeFilter，支持spring扫描{@link Buge}注解
		 */
		/*CustomScanner customScanner = new CustomScanner(ac);
		customScanner.resetFilters(false);
		customScanner.addIncludeFilter(new AnnotationTypeFilter(Buge.class));
		customScanner.scan("com.buge");*/
		System.out.println(((Annotation扩展1)ac.getBean("annotation扩展1")).t());
		System.out.println(ac.getBean("b"));
		System.out.println("=====================================");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-bean.xml");
		System.out.println(context.getBean("a"));
		System.out.println(context.getBeanFactory().getBeanDefinition("a"));
		System.out.println(context.getBeanFactory().getBeanDefinition("parent"));
		//System.out.println(context.getBean("b"))
		System.out.println(ac.getBean("transactional"));
		try {
			Thread.sleep(1000000000000000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
