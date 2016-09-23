package com.topcheer.ybt.system.dao;

import java.util.List;

import com.topcheer.ybt.system.entity.TopRoleinfo;


public interface TopRoleinfoMapper {
	
	public List<TopRoleinfo> searchTopRoleinfo(TopRoleinfo topRoleinfo);
	
	public List<TopRoleinfo> searchAll();
	
	public List<TopRoleinfo> getTopRoleinfo(String roleId);
	
	public void insert(TopRoleinfo topRoleinfo);
	
	public void update(TopRoleinfo topRoleinfo);
	
	public void delete(String roleId);
	
}
