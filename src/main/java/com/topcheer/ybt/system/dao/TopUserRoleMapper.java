package com.topcheer.ybt.system.dao;

import java.util.List;

import com.topcheer.ybt.system.entity.TopUserRole;

public interface TopUserRoleMapper {

	public List<TopUserRole> searchTopUserRole(TopUserRole topUserRole);

	public List<TopUserRole> searchAll();

	public List<TopUserRole> getTopUserRole(String userId);

	public void insert(TopUserRole topUserRole);

	public void update(TopUserRole topUserRole);

	public void delete(String userId);

	public void deleteByUserId(String userId);
	
	public void deleteByRoleId(String roleId);

}
