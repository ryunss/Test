package view;

import java.util.Scanner;

import dao.Session;
import dao.UserDAO;
import dto.UserDTO;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		
		System.out.print("아이디 : ");
		String userid = sc.next();
		System.out.print("비밀번호 : ");
		String userpw = sc.next();
		
		if(udao.login(userid,userpw)) {
			String username = ((UserDTO)Session.getData("loginUser")).username;
			System.out.println(username+"님 어서오세요~");
			new MainView();
		}
		else {
			System.out.println("로그인 실패 / 아이디 혹은 비밀번호를 다시 확인하세요");
		}
	}
}















