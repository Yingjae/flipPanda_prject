package com.flippanda.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.flippanda.user.mapper.UserMapper;
import com.flippanda.vo.UserAuthority;
import com.flippanda.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;
	
	@Override
	public void userInsert(UserVO userData){
		mapper.userInsert(userData);
	};
	@Override
	public UserVO getUserData(int userNum){
		UserVO userData = mapper.getUserData(userNum);		
		return userData;
				
	};
	@Override
	public void userDelete(int userNum){
		mapper.userDelete(userNum);
	};
	@Override
	public void userUpdate(UserVO userData){
		mapper.userUpdate(userData);
	}
	
	@Override
	public List<UserVO> getUserAllData() {
		List<UserVO> list = mapper.getUserAllData();
		return list;
	}
	@Override
	public List<UserAuthority> getUserAuth(int userNum) {
		return mapper.getUserAuth(userNum);
	}
	@Override
	public void autoSetUserAuth(UserVO userData) {
		mapper.autoSetUserAuth(userData);
	}
	@Override
	public void SetUserAuth( @Param("auth")String auth,@Param("userId")String userId) {
		System.out.println(" 유저 아이디 "+userId + " : " + "권한 : " + auth );
		mapper.SetUserAuth(userId, auth);
	};
}
