package com.test.iocdi;

public class UserServiceImpl implements UserService{
	private UserDao userdao = UserDaoFactory.getInstance();
	
	@Override
	public void addUser(User user) {
		userdao.save(user);
	}

}
