package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.C;
import service.Service;
import service.write.DeleteService;
import service.write.DetailService;
import service.write.ListService;
import service.write.SelectService;
import service.write.UpdateService;
import service.write.WriteService;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");   // 한글 인코딩
		action(request, response);
	}

	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n>> " + getClass().getName() + ".action() 호출");
		
		// URL로부터 URI, ContextPath, Command 분리
		String uri = request.getRequestURI();   // -->        /JSP18_MVC/board/aaa
		String conPath = request.getContextPath();  // -->    /JSP18_MVC
		String command = uri.substring(conPath.length());  // -->           /board/aaa
		
		// request method
		String method = request.getMethod();   // GET, POST, PUT, PATCH, DELETE ...

		// 매 request 마다 출력 (테스트)
		System.out.println("request: " + uri + " (" + method + ")");  
		System.out.println("conPath: " + conPath);  
		System.out.println("command: " + command);
		
		// 컨트롤러는 
		// 1. 커맨드에 따라, 해당 Service 로직을 수행을 하고
		// 2. 결과를 내보낼 view를 결정한다		
		Service service = null;   // 어떠한 Service 로직을 수행할지?
		String viewPage = null;   // 어떠한 페이지(view) 를 보여줄지?
		
		switch(command) {
		case "/board/write":
			if(C.securityCheck(request, response, new String[] {"ROLE_MEMBER"})) {				
				switch(method) {
				case "GET":
					viewPage = "write.jsp";
					break;
				case "POST":
					service = new WriteService();
					service.execute(request, response);
					viewPage = "writeOk.jsp";
					break;
				}
			}
			break;
		case "/board/list":
			service = new ListService();
			service.execute(request, response);
			viewPage = "list.jsp";
			break;
			
		case "/board/detail":  // 로그인한 사람만 접근 가능
			if(C.securityCheck(request, response, null)) {				
				service = new DetailService();
				service.execute(request, response);
				viewPage = "detail.jsp";
			}
			break;
			
		case "/board/update":  // ROLE_MEMBER + 작성자 만 접근 가능
			if(C.securityCheck(request, response, new String[] {"ROLE_MEMBER"})) {				
				switch(method) {
				case "GET":
					service = new SelectService();  // Service 안에서 작성자 여부 판단. 작성자 아니면 redirect 발생
					service.execute(request, response);
					
					if(!response.isCommitted()) { // 위에서 redirect 되면 forward 진행 안함.				
						viewPage = "update.jsp";
					}
					break;
				case "POST":
					service = new UpdateService();
					service.execute(request, response);
					viewPage = "updateOk.jsp";
					break;
				}
			}
			break;
			
		case "/board/delete":
			if(C.securityCheck(request, response, new String[] {"ROLE_MEMBER"})) {				
				switch(method) {
				case "POST":
					service = new DeleteService();   // 작성자가 아닌경우 Service 안에서 redirect 발생
					service.execute(request, response);
					if(!response.isCommitted()) {						
						viewPage = "deleteOk.jsp";
					}
					break;
				}
			}
			break;
		} // end switch
		
		// 위에서 결정된 뷰 페이지 (viewPage) 로 forward 해줌
		if(viewPage != null) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/WEB-INF/views/board/" + viewPage);
			
			dispatcher.forward(request, response);
		}
	
	
	} // end action()

} // end Controller











