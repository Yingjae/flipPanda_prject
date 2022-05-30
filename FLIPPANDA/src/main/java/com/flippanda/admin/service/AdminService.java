package com.flippanda.admin.service;

import java.util.List;

import com.flippanda.vo.AdminVO;

public interface AdminService {
	public void adminInsert(int userNum);
	public AdminVO getAdminData(int adminNum);
	public List<AdminVO> getAdminAllData();
	public void adminDelete(int adminNum);
	public void adminUpdate(AdminVO adminData);
}
