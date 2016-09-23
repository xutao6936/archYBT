package com.topcheer.ybt.system.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.entity.TopMenuRole;


public interface ITopMenuRoleService {
	
	public PageInfo<TopMenuRole> searchTopMenuRole(Map searchMap);
	
	public List<TopMenuRole> getTopMenuRoleList(String id);
	
	public List<TopMenuRole> searchMenuByRoleId(String id);
	
	public TopMenuRole getTopMenuRole(String id);
	
	public List<TopMenuRole> searchAll();
	
	public void insert(TopMenuRole topMenuRole);
	
	public void update(TopMenuRole topMenuRole);
	
	/**
	 * @throws Exception  
	* @Title: updateMenuByRoleId 
	* @Description: 根据用户角色类型更新菜单
	* @param @param topMenuRole
	* @return void
	* @throws 
	*/
	public void updateMenuByRoleId(TopMenuRole topMenuRole) throws Exception;
	
	public void delete(String id);
	
	public int deleteByRoleId(String roleId);

}
