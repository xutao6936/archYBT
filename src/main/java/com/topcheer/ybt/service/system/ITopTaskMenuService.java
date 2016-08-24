package com.topcheer.ybt.service.system;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;

import com.topcheer.ybt.entity.system.TopTaskMenu;
public interface ITopTaskMenuService {
	
	public PageInfo<TopTaskMenu> searchTopTaskMenu(Map searchMap);
	
	public List<TopTaskMenu> getTopTaskMenuList(String menuId);
	
	public TopTaskMenu getTopTaskMenu(String menuId);
	
	public List<TopTaskMenu> searchAll();
	
	public List<TopTaskMenu> searchByRoleId(String roleId);
	
	public void insert(TopTaskMenu topTaskMenu);
	
	public void update(TopTaskMenu topTaskMenu);
	
	public void delete(String id);
	
	/** 
	* @Title: deleteByRoleId 
	* @Description: 根据角色编码删除菜单 
	* @param @param roleId
	* @return int
	* @throws 
	*/
	public int deleteByRoleId(String roleId);

}
