package com.test.iocdi;

public class UserDaoFactory {
	public static UserDao getInstance() {
		//返回一个UserDdao
		return new UserDaoImpl();
	}
}
