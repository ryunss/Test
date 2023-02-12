package sqlmapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// MyBatis 최초 세팅을 위한 객체
public class SqlSessionManager {
	private static SqlSessionFactory sqlSessionFactory;
	
	// static 블럭은 프로그램 시작하면 가동
	static { // 최초에 실행됨
		String resource = "sqlmapper/Configuration.xml"; // 세팅 파일 읽어옴
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("SqlSessionFactory 생성");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static SqlSessionFactory getInstance() {
		return sqlSessionFactory; // static 에서 sqlSessionFactory 를 꺼내오기 위한 작업
	}
	
}
