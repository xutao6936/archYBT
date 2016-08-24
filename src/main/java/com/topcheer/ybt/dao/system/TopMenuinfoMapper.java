package com.topcheer.ybt.dao.system;

import java.util.List;
import java.util.Map;



import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.entity.system.TopMenuinfo;


public interface TopMenuinfoMapper {
	
	public List<TopMenuinfo> searchTopMenuinfo(TopMenuinfo topMenuinfo);
	
	public List<TopMenuinfo> searchAll();
	
	public List<TopMenuinfo> getTopMenuinfo(String menuId);
	
	public void insert(TopMenuinfo topMenuinfo);
	
	public void update(TopMenuinfo topMenuinfo);
	
	public void delete(String menuId);
	
	public List<MenuResult> getTopMenusByUserId(String loginAccount);
	
}
