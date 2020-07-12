package com.buge;

import com.buge.importselector.MyImportSelector;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author: yachen.shen
 * @Date 2020/2/3 12:34
 */
@ComponentScan("com.buge")
@Import({BugeRegistrar.class, MyImportSelector.class})
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Config {

	@Bean
	public DataSourceTransactionManager manager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource());
		return manager;
	}

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setUser("root");
			dataSource.setPassword("123456");
			dataSource.setJdbcUrl("jdbc:mysql://192.168.1.7:3306/syc?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public E getE() {
		System.out.println("e");
		getF();
		return new E();
	}

	@Bean
	public F getF() {
		System.out.println("f");
		//getE();
		return new F();
	}


}
