package com.test.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.test.dao.UserDao;
import com.test.entity.Address;
import com.test.entity.Role;
import com.test.entity.User;

public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	public static void main(String[] args) {
//		testSelectCount(); //計數
//		testAddUser(); //添加
//		testModifyUser(); //更改用戶
//		testModifyPwd(); //修改
//		testDelete(); //刪除
//		testFindUserById();//根据id查询用户
//		testFindUserByLikeUserName(); //根据名字进行模糊查询
//		testFindUserByNameAndId(); // 根据名字和id进行查询
//		testFindUserByRoleId();
//		testFindAddressListByUserId();
//		testUndefined();
//		testGetUserList();
	}

	// 测试匹配属性
	private static void testGetUserList() {
		logger.debug(" getUserList start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			User query = new User();
			query.setUserName("");
			query.setUserRole(2);
			List<User> users = sqlSession.getMapper(UserDao.class).getUserList(query);
			for (User user : users) {
				logger.info("userCode:" + user.getUserCode() + ",UserName:" + user.getUserName() + ",UserPassword"
						+ user.getUserPassword());
				Role role = user.getRole();
				if(null!=role) {
					logger.info("roleCode:" + role.getRoleCode() + ",roleName:" + role.getRoleName());
				}
			}
			if (null == users || users.size() <= 0) {
				logger.info("userSize:" + users.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("getUserList end");
		}
	}

	// 测试匹配属性
	private static void TestFindUserListByNameAndRoleId() {
		logger.debug(" findUserListByNameAndRoleId start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			List<User> users = sqlSession.getMapper(UserDao.class).findUserListByNameAndRoleId(null, "五");
			for (User user : users) {
				logger.info("userCode:" + user.getUserCode() + ",UserName:" + user.getUserName() + ",UserPassword"
						+ user.getUserPassword());
				Role role = user.getRole();
				logger.info("roleCode:" + role.getRoleCode() + ",roleName:" + role.getRoleName());
			}
			if (null == users || users.size() <= 0) {
				logger.info("userSize:" + users.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("findUserListByNameAndRoleId end");
		}
	}

	// 测试匹配属性
	private static void testUndefined() {
		logger.debug(" testUndefined start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			Integer userId = 2;
			List<User> users = sqlSession.getMapper(UserDao.class).findAddressListByUserId(userId);
			for (User user : users) {
				logger.info("usercode:" + user.getUserCode() + ",userName:" + user.getUserName()
						+ ",<未做映射的字段>userPassword:" + user.getUserPassword());
				List<Address> addresses = user.getAddressList();
				if (null != addresses && addresses.size() > 0) {
					for (Address address : addresses) {
						logger.info("addressDesc:" + address.getAddressDesc() + ",tel:" + address.getTel()
								+ "<未做映射字段> userId:" + address.getUserId());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testUndefined end");
		}
	}

	// 测试findUserByRoleId
	private static void testFindAddressListByUserId() {
		logger.debug(" testFindAddressListByUserId start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			Integer roleId = 2;
			List<User> users = sqlSession.getMapper(UserDao.class).findAddressListByUserId(roleId);
			for (User user : users) {
				logger.info("user的名字是：" + user.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testFindAddressListByUserId end");
		}
	}

	// 测试findUserByRoleId
	private static void testFindUserByRoleId() {
		logger.debug(" testFindUserByRoleId start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			Integer roleId = 2;
			List<User> users = sqlSession.getMapper(UserDao.class).findUserByRoleId(roleId);
			for (User user : users) {
				logger.info("user的名字是：" + user.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testFindUserByRoleId end");
		}
	}

	private static void testFindUserByNameAndId() {
		logger.debug(" testFindUserByNameAndId start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			User user = sqlSession.getMapper(UserDao.class).findUserByNameAndId(1, "张三");
			logger.info("user的名字是:" + user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testFindUserByNameAndId end");
		}
	}

	// 测试根据名字进行模糊查询
	private static void testFindUserByLikeUserName() {
		logger.debug(" testFindUserByLikeUserName start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			List<User> users = sqlSession.getMapper(UserDao.class).findUserByLikeUserName("三");
			for (User user : users) {
				logger.info("user的名字是:" + user.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testFindUserByLikeUserName end");
		}
	}

	// 測試根據編號獲取數據
	private static void testFindUserById() {
		logger.debug(" testFindUserById start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			User user = sqlSession.getMapper(UserDao.class).findUserById(1);
			logger.info("user的名字是:" + user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testFindUserById end");
		}
	}

	// 測試刪除方法
	private static void testDelete() {
		logger.debug(" testDelete start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			sqlSession.getMapper(UserDao.class).deleteUser(2);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testDelete end");
		}
	}

	// 测试修改密码
	private static void testModifyPwd() {
		logger.debug(" testModifyPwd start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			sqlSession.getMapper(UserDao.class).updatePwd(1, "321");
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("addUser end");
		}
	}

	// 测试添加方法
	private static void testAddUser() {
		logger.debug(" addUser start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			User user = new User();
			user.setId(2);
			user.setUserCode("test001");
			user.setUserName("李四");
			user.setUserPassword("123456");
			Date birthDay = new SimpleDateFormat("yyyy-MM-dd").parse("1999-12-12");
			user.setBirthday(birthDay);
			user.setAddress("内蒙点");
			user.setGender(1);
			user.setPhone("123456789111");
			user.setUserRole(1);
			user.setCreatedBy(1);
			user.setCreationDate(new Date());
			// 如果出现明显的错误比如:5/0
//			int count = 5/0;
			sqlSession.getMapper(UserDao.class).addUser(user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testModifyPwd end");
		}
	}

	// 测试修改方法
	private static void testModifyUser() {
		logger.debug(" testModifyUser start ");
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫Resources的工县类,它包含一些实用方法,可使从classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例SqlSessionFactory
			SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = SqlSessionFactory.openSession();
			User user = new User();
			user.setId(2);
			user.setUserCode("test002");
			user.setUserName("王五");
			user.setUserPassword("132314");
			Date birthDay = new SimpleDateFormat("yyyy-MM-dd").parse("1999-12-12");
			user.setBirthday(birthDay);
			user.setAddress("内蒙点");
			user.setGender(0);
			user.setPhone("123456789111");
			user.setUserRole(2);
			user.setModifyBy(2);
			user.setModifyDate(new Date());
			sqlSession.getMapper(UserDao.class).modifyUser(user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("事务回滚了");
			sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
			logger.debug("testModifyUser end");
		}
	}

	// 测试基础环境
	private static void testSelectCount() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			// MyBatis 包含一个名叫 Resources 的工具类，它包含一些实用方法，可使从 classpath 或其他位置加载资源文件
			inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactoryBuild来创建一个SqlSessionFactory实例
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			int count = sqlSession.getMapper(UserDao.class).count();
			System.out.print("count is " + count);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}
	}
}
