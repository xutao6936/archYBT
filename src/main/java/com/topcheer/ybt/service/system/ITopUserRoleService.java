package com.topcheer.ybt.service.system;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;

import com.topcheer.ybt.entity.system.TopUserRole;
public interface ITopUserRoleService {
	
	public PageInfo<TopUserRole> searchTopUserRole(Map<String,Object> searchMap);
	
	public List<TopUserRole> getTopUserRoleList(String userId);
	
	public TopUserRole getTopUserRole(String userId);
	
	public List<TopUserRole> searchAll();
	
	public void insert(TopUserRole topUserRole);
	
	public void update(TopUserRole topUserRole);
	
	public void delete(String id);
	
	public void deleteByUserId(String userId);

}
