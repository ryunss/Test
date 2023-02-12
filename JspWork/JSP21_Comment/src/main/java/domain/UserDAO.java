package domain;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
	// username 으로 특정 회원(user) SELECT <-- 매개변수는 DTO
	// 회원가입 등에서 필요. (중복가입 여부 등(id가 중복됏냐?))
	public abstract List<UserDTO> selectByUsername(UserDTO dto) throws SQLException;
	
	// id로 특정 회원(user) SELECT <-- 매개변수는 DTO
	public abstract List<UserDTO> selectById(UserDTO dto) throws SQLException;
	
	// 회원(user) 등록 INSERT <-- 매개변수는 DTO
	public abstract int register(UserDTO dto) throws SQLException;
	
}
