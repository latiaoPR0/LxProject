package com.test.proxy;

import com.test.dao.Accreditation;

public class ProxyAccreditation implements Accreditation{
	private EntrustPerson entrustPerson;
	
	public ProxyAccreditation(EntrustPerson entrustPerson) {
		this.entrustPerson = entrustPerson;
	}
	
	@Override
	public void handle(int money, int hour) {
		money+=100;
		hour=2;
		entrustPerson.handle(money, hour);
		System.out.println("办理完成");
		entrustPerson.show();
	}
	
}
