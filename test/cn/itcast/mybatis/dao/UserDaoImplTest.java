package cn.itcast.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserDaoImplTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	//这个方法是testFindUserById方法执行之前执行的
	@Before
	public void setUp()throws Exception{
		//创建sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		//fail("Not yet implemented");
		
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(1);
		System.out.println(user);
		
	}

}
