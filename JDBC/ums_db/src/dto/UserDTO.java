package dto;

public class UserDTO {
	public String userid;
	public String userpw;
	public String username;
	public int userage;
	public String userphone;
	public String useraddr;
	
	public UserDTO() {}
	
	public UserDTO(String userid, String userpw, String username, int userage, String userphone, String useraddr) {
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userage = userage;
		this.userphone = userphone;
		this.useraddr = useraddr;
	}
	
	public UserDTO(String[] datas) {
		this.userid = datas[0];
		this.userpw = datas[1];
		this.username = datas[2];
		this.userage = Integer.parseInt(datas[3]);
		this.userphone = datas[4];
		this.useraddr = datas[5];
	}
	
	@Override
	public String toString() {
		return userid+"\t"+userpw+"\t"+username+"\t"+userage+"\t"+userphone+"\t"+useraddr;
	}
}





