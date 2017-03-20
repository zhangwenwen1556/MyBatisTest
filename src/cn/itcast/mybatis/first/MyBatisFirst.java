package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MyBatisFirst {

	// 根据ID查询用户的信息
	@Test
	public void findUserByIdTest() throws IOException {

		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 获取到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建回话工厂，需要传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂获取到sqlSession

		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlSession操作数据库

		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);

		// 释放资源
		sqlSession.close();

	}
	//添加一条记录
	@Test
	public void insertUser() throws IOException {

		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSessoin = sqlSessionFactory.openSession();

		User user = new User();
		user.setUsername("张三");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("上海松江");

		sqlSessoin.insert("test.insertUser", user);
		// 这里一定要记住提交事务，在和spring整合以后这里的事务提交将会交给spring处理
		System.out.println(user.getId());
		sqlSessoin.commit();

		sqlSessoin.close();

	}
	//修改一条记录
	@Test
	public void updateUserTest() throws IOException {

		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(2);
		user.setUsername("李四");
		user.setAddress("上海松江区泗凯路");
		user.setSex("女");

		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();

	}
	//删除一调记录
	@Test
	public void deleteUserTest() throws IOException {

		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUser", 3);
		sqlSession.commit();
		sqlSession.close();
		
	}
}
