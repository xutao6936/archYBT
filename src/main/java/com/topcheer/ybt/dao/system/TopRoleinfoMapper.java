package com.topcheer.ybt.dao.system;

import java.util.List;
import java.util.Map;


import com.topcheer.ybt.entity.system.TopRoleinfo;


public interface TopRoleinfoMapper {
	
	public List<TopRoleinfo> searchTopRoleinfo(TopRoleinfo topRoleinfo);
	
	public List<TopRoleinfo> searchAll();
	
	public List<TopRoleinfo> getTopRoleinfo(String roleId);
	
	public void insert(TopRoleinfo topRoleinfo);
	
	public void update(TopRoleinfo topRoleinfo);
	
	public void delete(String roleId);
	
}
