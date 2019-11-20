package com.test.iocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTocDi {
	private static Logger log = LoggerFactory.getLogger(TestTocDi.class);
	
	public static void main(String[] args) {
		initSpring();
	}

	private static void initSpring() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.show();
		
	}

}
