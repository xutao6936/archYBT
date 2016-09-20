package com.topcheer.ybt.dao.system;

import java.util.List;
import java.util.Map;


import com.topcheer.ybt.entity.system.TopUserRole;


public interface TopUserRoleMapper {
	
	public List<TopUserRole> searchTopUserRole(TopUserRole topUserRole);
	
	public List<TopUserRole> searchAll();
	
	public List<TopUserRole> getTopUserRole(String userId);
	
	public void insert(TopUserRole topUserRole);
	
	public void update(TopUserRole topUserRole);
	
	public void delete(String userId);
	
	public void deleteByUserId(String userId);
	
}
