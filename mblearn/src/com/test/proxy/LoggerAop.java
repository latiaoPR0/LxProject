package com.test.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAop {
	private static Logger log = LoggerFactory.getLogger(LoggerAop.class);
	
	public void startProcess() {
		log.info("---------------开始运行");
	}
}
