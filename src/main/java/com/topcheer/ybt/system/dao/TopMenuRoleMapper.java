package com.topcheer.ybt.system.dao;

import java.util.List;

import com.topcheer.ybt.system.entity.TopMenuRole;


public interface TopMenuRoleMapper {
	
	public List<TopMenuRole> searchTopMenuRole(TopMenuRole topMenuRole);
	
	/** 
	* @Title: searchMenuByRoleId 
	* @Description: 根据角色类型查询当前角色菜单
	* @param @param roleId
	* @param @return
	* @return List<TopMenuRole>
	* @throws 
	*/
	public List<TopMenuRole> searchMenuByRoleId(String roleId);
	
	public List<TopMenuRole> searchAll();
	
	public List<TopMenuRole> getTopMenuRole(String id);
	
	public void insert(TopMenuRole topMenuRole);
	
	public void update(TopMenuRole topMenuRole);
	
	public void delete(String id);
	
	/** 
	* @Title: deleteByRoleId 
	* @Description: 删除当前角色下的菜单
	* @param @param roleId
	* @return void
	* @throws 
	*/
	public int deleteByRoleId(String roleId);
	
	public int deleteByMenuId(String menuId);
	
}
