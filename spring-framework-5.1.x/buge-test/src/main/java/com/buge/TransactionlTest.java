package com.buge;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yachen.shen
 * @Date 2020/3/17 18:41
 */
@Component("transactional")
public class TransactionlTest {

	@Transactional
	public void insert() {
		System.out.println("==================insert===============");
	}

}
