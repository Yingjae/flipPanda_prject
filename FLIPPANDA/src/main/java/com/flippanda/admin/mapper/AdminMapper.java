package com.flippanda.admin.mapper;

import java.util.List;

import com.flippanda.vo.AdminVO;

public interface AdminMapper {
	public void adminInsert(int userNum);
	public AdminVO getAdminData(int adminNum);
	public List<AdminVO> getAdminAllData();
	public void adminDelete(int adminNum);
	public void adminUpdate(AdminVO adminData);
}
