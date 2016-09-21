package com.topcheer.ybt.system.dao;

import java.util.List;

import com.topcheer.ybt.system.entity.TopTaskMenu;

public interface TopTaskMenuMapper {

	public List<TopTaskMenu> searchTopTaskMenu(TopTaskMenu topTaskMenu);

	public List<TopTaskMenu> searchAll();

	public List<TopTaskMenu> getTopTaskMenu(String menuId);

	public void insert(TopTaskMenu topTaskMenu);

	public void update(TopTaskMenu topTaskMenu);

	public void delete(String menuId);

	public int deleteByRoleId(String roleId);

}
