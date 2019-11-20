package com.test.dao;
/**
 * 办证
 * @author 张伟民
 *
 */
public interface Accreditation {
	/**
	 * 办理
	 * 花费金额
	 * 花费时间
	 */
	public void handle(int money,int hour); 
}
