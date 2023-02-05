package service.write;

import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.WriteDAO;
import domain.WriteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import service.Service;
import sqlmapper.SqlSessionManager;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		// 입력한 값 (parameter) 받아오기
		int id = Integer.parseInt(request.getParameter("id"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// ※ 이 단계에서 parameter 검증해야한다.
		
		SqlSession sqlSession = null;
		WriteDAO dao = null;
		
		int cnt = 0;
		
//		WriteDTO dto = new WriteDTO();
//		dto.setId(id);
//		dto.setSubject(subject);
//		dto.setContent(content);
		
		// 빌드패턴 방식으로도 만들 수 있음 WriteDTO 에 어노테이션해뒀음 2개
		// @Builder @AllArgsConstructor
		// Builder 사용한 생성
		WriteDTO dto = WriteDTO.builder()
			.id(id)
			.subject(subject)
			.content(content)
			.build()
			;
		
		
		try {
			sqlSession = SqlSessionManager.getInstance().openSession();
			dao = sqlSession.getMapper(WriteDAO.class);
			
			cnt = dao.update(dto);
			
			sqlSession.commit();
		} catch (SQLException e) {  
			e.printStackTrace();
		} finally {
			if(sqlSession!= null) sqlSession.close();
		}
 
		request.setAttribute("result", cnt);
		request.setAttribute("dto", dto); // id값을 전달하기 위해
	
	}

}
