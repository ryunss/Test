package com.koreait.mapper;

import org.apache.ibatis.annotations.Param;

import com.koreait.domain.UserDTO;

public interface UserMapper {
	int join(UserDTO user);
	// MyBatis는 두개 이상의 파라미터를 넘길 때 객체나 Map, List, 혹은 @Param을 이용한다.
	// 정해진 파라미터는 MyBatis에서 #{param명}으로 사용 가능하다.
	UserDTO login(@Param("userid")String userid, @Param("userpw")String userpw);
}
