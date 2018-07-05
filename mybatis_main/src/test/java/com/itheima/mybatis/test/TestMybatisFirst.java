package com.itheima.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class TestMybatisFirst {
	
	/**
	 * 测试用例：根据id查询用户
	 * @throws IOException 
	 */
	@Test
	public void testQueryUserById() throws IOException{
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// SqlSessionFactory获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 调用sqlSession的api
		 * param1：锁定sql语句的唯一标识符
		 * param2：传入的参数
		 */
		User user = sqlSession.selectOne("test.queryUserById", 10);
		System.out.println(user);
		// 关闭session，底层把数据库连接放入连接池
		sqlSession.close();
	}
	
	
	/**
	 * 测试用例：根据用户名模糊查询列表#
	 * @throws IOException 
	 */
	@Test
	public void testQueryUserByUsername() throws IOException{
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// SqlSessionFactory获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 调用sqlSession的api
		 * param1：锁定sql语句的唯一标识符
		 * param2：传入的参数
		 */
		/**
		 * 多条记录不能使用selectOne，否则异常
		 * Expected one result (or null) to be returned by selectOne(), but found: 2
		 */
		List<User> list = sqlSession.selectList("test.queryUserByUsername", "%王%");
		if(list != null && list.size() > 0) {
			for (User user : list) {
				System.out.println(user);
			}
		}
		// 关闭session，底层把数据库连接放入连接池
		sqlSession.close();
	}
	
	
	/**
	 * 测试用例：根据用户名模糊查询列表$
	 * @throws IOException 
	 */
	@Test
	public void testQueryUserByUsername2() throws IOException{
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// SqlSessionFactory获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 调用sqlSession的api
		 * param1：锁定sql语句的唯一标识符
		 * param2：传入的参数
		 */
		/**
		 * 多条记录不能使用selectOne，否则异常
		 * Expected one result (or null) to be returned by selectOne(), but found: 2
		 */
		List<User> list = sqlSession.selectList("test.queryUserByUsername2", "'%王%'");
		if(list != null && list.size() > 0) {
			for (User user : list) {
				System.out.println(user);
			}
		}
		// 关闭session，底层把数据库连接放入连接池
		sqlSession.close();
	}
	
	
	/**
	 * 测试用例：添加用户
	 * @throws IOException 
	 */
	@Test
	public void testSaveUser() throws IOException{
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// SqlSessionFactory获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 调用sqlSession的api
		 * param1：锁定sql语句的唯一标识符
		 * param2：传入的参数
		 */
		User user = new User();
		user.setUsername("刘备");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("蜀国");
		sqlSession.insert("test.saveUser", user);
		System.out.println(user);
		sqlSession.commit();
		// 关闭session，底层把数据库连接放入连接池
		sqlSession.close();
	}
	
	
	/**
	 * 测试用例：更新用户
	 * @throws IOException 
	 */
	@Test
	public void testUpdateUserById() throws IOException{
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// SqlSessionFactory获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 调用sqlSession的api
		 * param1：锁定sql语句的唯一标识符
		 * param2：传入的参数
		 */
		User user = new User();
		user.setId(1);
		user.setUsername("诸葛孔明");
		sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
		// 关闭session，底层把数据库连接放入连接池
		sqlSession.close();
	}
	
	
	/**
	 * 测试用例：删除用户
	 * @throws IOException 
	 */
	@Test
	public void testDeleteUserById() throws IOException{
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// SqlSessionFactory获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 调用sqlSession的api
		 * param1：锁定sql语句的唯一标识符
		 * param2：传入的参数
		 */
		sqlSession.delete("test.deleteUserById", 1);
		sqlSession.commit();
		// 关闭session，底层把数据库连接放入连接池
		sqlSession.close();
	}

}
