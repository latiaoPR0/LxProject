package com.test.proxy;

import com.test.dao.Accreditation;

public class EntrustPerson implements Accreditation{
	
	private int vacancies = 1000; // 金额
	private int spendHour = 0;//时间
	
	@Override
	public void handle(int money, int hour) {
		this.vacancies -= money;//花费
		this.spendHour = hour;
	}
	/**
	 * 显示信息
	 */
	public void show() {
		System.out.println("1000元还剩:"+vacancies+"元");
		System.out.println("花费了:"+spendHour+"小时");
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public int getSpendHour() {
		return spendHour;
	}
	public void setSpendHour(int spendHour) {
		this.spendHour = spendHour;
	}

	
}
