package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class MyBatisTest {

	public static void main(String[] args) {
		SqlSessionFactory factory = SqlMapConfig.getFactory();
		System.out.println(factory);
		SqlSession session = factory.openSession();
		System.out.println(session);
	}

}
