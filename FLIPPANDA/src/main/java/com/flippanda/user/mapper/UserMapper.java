package com.flippanda.user.mapper;

import java.util.List;

import com.flippanda.vo.UserVO;

public interface UserMapper {
	public void userInsert(UserVO userData);
	public UserVO getUserData(int userNum);
	public List<UserVO> getUserAllData();
	public void userDelete(int userNum);
	public void userUpdate(UserVO userData);
}
