package com.buge;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: yachen.shen
 * @Date 2020/2/4 15:27
 * {@link CustomScanner}//实现注解扩展（mybatis的@mapperScanner）
 */
@Buge
public class Annotation扩展1 {

	@Autowired
	public C b;




	public String t() {
		System.out.println("扩展,b=" + b);
		return "扩展成功";
	}
}
