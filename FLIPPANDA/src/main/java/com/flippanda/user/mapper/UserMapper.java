package com.flippanda.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.flippanda.vo.UserAuthority;
import com.flippanda.vo.UserVO;

public interface UserMapper {
	public void userInsert(UserVO userData);
	public UserVO getUserData(int userNum);
	public List<UserVO> getUserAllData();
	public void userDelete(int userNum);
	public void userUpdate(UserVO userData);
	public List<UserAuthority> getUserAuth(int userNum);
	public void autoSetUserAuth (UserVO userData);
	public void SetUserAuth ( @Param("auth")String auth,@Param("userId")String userId);
	public UserVO read(String username);
}
