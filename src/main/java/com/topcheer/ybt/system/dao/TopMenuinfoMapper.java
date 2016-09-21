package com.topcheer.ybt.system.dao;

import java.util.List;

import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.system.entity.TopMenuinfo;

public interface TopMenuinfoMapper {

	public List<TopMenuinfo> searchTopMenuinfo(TopMenuinfo topMenuinfo);

	public List<TopMenuinfo> searchAll();

	/**
	 * @Title: searchMenuByRoleId
	 * @Description: 根据用户编号查询用户菜单
	 * @param @param roleId
	 * @param @return
	 * @return List<TopMenuinfo>
	 * @throws
	 */
	public List<TopMenuinfo> searchMenuByUserId(String userId);

	public List<TopMenuinfo> getTopMenuinfo(String menuId);

	public void insert(TopMenuinfo topMenuinfo);

	public void update(TopMenuinfo topMenuinfo);

	public void delete(String menuId);

	public List<MenuResult> getTopMenusByUserId(String loginAccount);

}
