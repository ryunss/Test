package view;

import java.util.HashSet;
import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.UserDTO;

public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		System.out.println("======메인화면======");
		while(true) {
			UserDTO loginUser = (UserDTO)Session.getData("loginUser");
			if(loginUser == null) {
				System.out.println("로그인 후 이용하세요!");
				break;
			}
			System.out.println("1. 상품 추가\n2. 상품 수정\n3. 상품 삭제\n4. 내 상품 보기\n5. 상품 검색\n6. 내 정보 수정\n7. 로그아웃");
			int choice = sc.nextInt();
			HashSet<String> list = null;
			
			if(choice == 7) {
				System.out.println(loginUser.username+"님 다음에 또 오세요~");
				Session.setData("loginUser", null);
				break;
			}
			switch(choice) {
			case 1:
				//상품 추가
				new AddProductView();
				break;
			case 2:
				//상품 수정
				new ModifyProductView();
				break;
			case 3:
				//상품 삭제
				list = pdao.getList();
				System.out.println("=========내가 올린 상품 목록=========");
				if(list.size() == 0) {
					System.out.println("등록한 상품이 없습니다!");
				}
				else {
					for(String line : list) {
						String[] datas = line.split("\t");
						System.out.printf("%s. %s : %s원(재고 : %s개)\n",datas[0],datas[1],datas[2],datas[3]);
					}
				}
				System.out.println("==============================");
				System.out.print("삭제할 상품 번호 : ");
				int prodnum = sc.nextInt();
				if(pdao.removeProduct(prodnum)) {
					System.out.println(prodnum+"번 상품 삭제 완료!");
				}
				else {
					System.out.println("상품 삭제 실패 / 다음에 다시 시도해 주세요.");
				}
				break;
			case 4:
				//내 상품 보기
				list = pdao.getList();
				System.out.println("=========내가 올린 상품 목록=========");
				if(list.size() == 0) {
					System.out.println("등록한 상품이 없습니다!");
				}
				else {
					for(String line : list) {
						String[] datas = line.split("\t");
						System.out.printf("%s. %s : %s원(재고 : %s개)\n",datas[0],datas[1],datas[2],datas[3]);
					}
				}
				System.out.println("==============================");
				break;
			case 5:
				//상품 검색
				//키워드 입력받기
				//키워드가 이름이나 설명에 포함되어 있는 상품들 목록 띄워주기
				//자세히 볼 상품번호 : 
				//선택한 상품에 대해 자세히 보여주는 뷰로 이동(상품번호, 이름, 가격, 재고, 좋아요개수, 설명)
				//1. 좋아요 누르기 2. 판매자와 연락하기(연락처 보여주기) 3. 뒤로가기
				break;
			case 6:
				//내 정보 수정
				new MyInfoView();
				break;
			}
		}
	}
}








