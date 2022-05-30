package com.flippanda.user.service;

import java.util.List;

import com.flippanda.vo.UserAuthority;
import com.flippanda.vo.UserVO;

public interface UserService {
	public void userInsert(UserVO userData);
	public UserVO getUserData(int userNum);
	public List<UserVO> getUserAllData();
	public void userDelete(int userNum);
	public void userUpdate(UserVO userData);
	public List<UserAuthority> getUserAuth(int userNum);
	public void autoSetUserAuth (UserVO userData);
}
