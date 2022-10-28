package view;

import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class JoinView {
	public JoinView() {
		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		System.out.println("======회원가입 페이지 입니다======");
		System.out.print("아이디 : ");
		String userid = sc.next();
		//중복체크를 위한 메소드 호출
		if(udao.checkId(userid)) {
			System.out.print("비밀번호 : ");
			String userpw = sc.next();
			if(userpw.length()>=8) {
				System.out.print("이름 : ");
				String username = sc.next();
				System.out.print("나이 : ");
				int userage = sc.nextInt();
				System.out.print("핸드폰번호 : ");
				String userphone = sc.next();
				System.out.print("주소 : ");
				sc = new Scanner(System.in);
				String useraddr = sc.nextLine();
				
				UserDTO newUser = new UserDTO(userid, userpw, username, userage, userphone, useraddr);
				
				
				if(udao.join(newUser)) {
					System.out.println("회원가입 성공!");
				}
				else {
					System.out.println("회원가입 실패 / 다음에 다시 시도해주세요.");
				}
			}
			else {
				System.out.println("비밀번호는 8자 이상이어야 합니다.");
			}
		}
		else {
			System.out.println("중복된 아이디가 있습니다.");
		}
	}
}








