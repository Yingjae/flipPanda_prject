package com.filppanda.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flippanda.admin.mapper.AdminMapper;
import com.flippanda.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper mapper;
	
	@Override
	public void adminInsert(AdminVO adminData){
		mapper.adminInsert(adminData);
	};
	@Override
	public AdminVO getAdminData(int adminNum){
		return mapper.getAdminData(adminNum);
	};
	@Override
	public void adminDelete(int adminNum){
		mapper.adminDelete(adminNum);
	};
	@Override
	public void adminUpdate(AdminVO adminData){
		mapper.adminUpdate(adminData);
	}
	
	@Override
	public List<AdminVO> getAdminAllData() {
		return mapper.getAdminAllData();
	};
}
