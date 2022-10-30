package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ProductDTO;
import dto.UserDTO;

public class ProductDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public ProductDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean addProduct(ProductDTO newProduct) {
		try {
			String sql = "insert into product (prodname,prodprice,prodamount,prodinfo,userid) "
					+ "values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newProduct.prodname);
			ps.setInt(2, newProduct.prodprice);
			ps.setInt(3, newProduct.prodamount);
			ps.setString(4, newProduct.prodinfo);
			ps.setString(5, newProduct.userid);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public ArrayList<ProductDTO> getList() {
		String userid = ((UserDTO)Session.getData("loginUser")).userid;
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		
		try {
			String sql = "select * from product where userid = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductDTO p = new ProductDTO();
				p.prodnum = rs.getInt("prodnum");
				p.prodname = rs.getString("prodname");
				p.prodprice = rs.getInt("prodprice");
				p.prodamount = rs.getInt("prodamount");
				p.prodinfo = rs.getString("prodinfo");
				p.likecnt = rs.getInt("likecnt");
				p.userid = rs.getString("userid");
				
				result.add(p);
			}
			
		} catch (SQLException e) {
		}
		return result;
	}

	public boolean removeProduct(int prodnum) {
		try {
			String sql = "delete from product where prodnum="+prodnum;
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean modifyProduct(int prodnum, int choice, String newData) {
		//choice : 1(가격수정 - 2), 2(재고수정 - 3), 3(설명수정 - 4)
		return false;
	}

	public boolean removeAll(String userid) {
		try {
			String sql = "delete from product where userid=?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			
			return ps.executeUpdate() != 0;
		} catch (SQLException e) {
		}
		return false;
	}
}





