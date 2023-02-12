package service.comment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.CommentDAO;
import domain.CommentDTO;
import domain.QryCommentList;
import service.Service;
import sqlmapper.SqlSessionManager;

public class CmtListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id")); // 글의 id
		
		QryCommentList obj = new QryCommentList();
//		QryResult obj = new QryResult(); // response 할 Java 객체 준비
		ObjectMapper mapper = new ObjectMapper(); // JSON으로 매핑할 Mapper 객체
		
//		obj.setCount(11);
//		obj.setStatus("OK");
//		obj.setMemo("메모입니다");
		
		SqlSession sqlSession = null;
		CommentDAO dao = null;		
		
		try {
			sqlSession = SqlSessionManager.getInstance().openSession();
			dao = sqlSession.getMapper(CommentDAO.class);
			
			List<CommentDTO> list = dao.selectByWrite(id);
			obj.setList(list);;
			obj.setCount(list.size());
			obj.setStatus("OK");
			
			sqlSession.commit();
		} catch (SQLException e) {  
			e.printStackTrace();
			obj.setStatus("댓글목록 ERROR: " + e.getMessage());
		} finally {
			if(sqlSession!= null) sqlSession.close();
		}

		
//		String output = mapper.writeValueAsString(obj); // 포매팅 x 실무에선 이렇게 많이 씀. 밑에껀 엔터때메 메모리낭비
		String output = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj); // 포매팅
//		System.out.println(output);
		response.setContentType("application/json; charset=utf-8"); // MIME 설정
		response.getWriter().write(output); // response에 보내기
	}

}
