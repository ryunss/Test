package dto;


public class BoardDTO {
	private int boardnum;
	private String subject;
	private String content;
//	private UserDTO user;
	private String userid;
	
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public UserDTO getUser() {
//		return user;
//	}
//	public void setUser(UserDTO user) {
//		this.user = user;
//	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
