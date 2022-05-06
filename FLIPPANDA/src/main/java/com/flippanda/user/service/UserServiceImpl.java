package com.flippanda.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flippanda.user.mapper.UserMapper;
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
		return mapper.getUserData(userNum);
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
		return mapper.getUserAllData();
	};
}
