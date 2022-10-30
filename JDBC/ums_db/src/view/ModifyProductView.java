package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import dao.ProductDAO;
import dto.ProductDTO;

public class ModifyProductView {
	public ModifyProductView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		ArrayList<ProductDTO> list = pdao.getList();
		System.out.println("=========내가 올린 상품 목록=========");
		if(list.size() == 0) {
			System.out.println("등록한 상품이 없습니다!");
		}
		else {
			for(ProductDTO p : list) {
				System.out.printf("%d. %s : %d원(재고 : %d개)\n",p.prodnum,p.prodname,p.prodprice,p.prodamount);
			}
		}
		System.out.print("수정할 상품 번호 : ");
		int prodnum = sc.nextInt();
		System.out.println("1. 가격수정\n2. 재고수정\n3. 설명수정");
		int choice = sc.nextInt();
		System.out.print("새로운 정보 : ");
		sc = new Scanner(System.in);
		String newData = sc.nextLine();
		
		if(pdao.modifyProduct(prodnum,choice,newData)) {
			System.out.println(prodnum+"번 상품 수정 성공!");
		}
		else {
			System.out.println("상품 수정 실패 / 다음에 다시 시도해 주세요.");
		}
	}
}




