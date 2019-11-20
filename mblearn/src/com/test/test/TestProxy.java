package com.test.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.proxy.EntrustPerson;
import com.test.proxy.ProxyAccreditation;

public class TestProxy {
	private static Logger log = LoggerFactory.getLogger(TestProxy.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		log.info("自己办理");
		EntrustPerson entrustPerson = (EntrustPerson) context.getBean("entrustPerson");
		entrustPerson.handle(200, 5);
		entrustPerson.show();
		log.info("代理办理");
		EntrustPerson entrustPerson2 = new EntrustPerson();
		ProxyAccreditation proxyAccreditation = new ProxyAccreditation(entrustPerson2);
		proxyAccreditation.handle(200, 5);
		
	}

}
