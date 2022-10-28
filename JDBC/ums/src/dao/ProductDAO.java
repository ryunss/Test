package dao;

import java.util.HashSet;

import dto.ProductDTO;
import dto.UserDTO;

public class ProductDAO {
	DBConnection conn;
	
	public ProductDAO() {
		conn = new DBConnection("ProductTable.txt");
	}

	public int getLastNum() {
		String lastPK = conn.lastPK();
		if(lastPK == null) {
			return 0;
		}
		else {
			return Integer.parseInt(lastPK);
		}
	}

	public boolean addProduct(ProductDTO newProduct) {
		return conn.insert(newProduct.toString());
	}

	public HashSet<String> getList() {
		String userid = ((UserDTO)Session.getData("loginUser")).userid;
		HashSet<String> rs = conn.select(6,userid);
		return rs;
	}

	public boolean removeProduct(int prodnum) {
		return conn.delete(prodnum+"");
	}

	public boolean modifyProduct(int prodnum, int choice, String newData) {
		//choice : 1(가격수정 - 2), 2(재고수정 - 3), 3(설명수정 - 4)
		return conn.update(prodnum+"", choice+1, newData);
	}

	public boolean removeAll(String userid) {
		boolean check = false;
		HashSet<String> rs = conn.select(6,userid);
		for(String line : rs) {
			check = conn.delete(line.split("\t")[0]);
			if(!check) {
				return false;
			}
		}
		return true;
	}
	
}





