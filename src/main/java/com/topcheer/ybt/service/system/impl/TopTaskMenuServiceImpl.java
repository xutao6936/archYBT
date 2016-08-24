package com.topcheer.ybt.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.dao.system.TopTaskMenuMapper;
import com.topcheer.ybt.entity.system.TopTaskMenu;
import com.topcheer.ybt.service.system.ITopTaskMenuService;


@Service("topTaskMenuService")
@Transactional
public class TopTaskMenuServiceImpl implements ITopTaskMenuService{
	
	@Autowired
	protected TopTaskMenuMapper topTaskMenuMapper;

	public void delete(String id) {
		topTaskMenuMapper.delete(id);
		
	}

	public List<TopTaskMenu> getTopTaskMenuList(String menuId) {
		return topTaskMenuMapper.getTopTaskMenu(menuId);
	}
	
	public TopTaskMenu getTopTaskMenu(String menuId) {
		List<TopTaskMenu> list = topTaskMenuMapper.getTopTaskMenu(menuId);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopTaskMenu topTaskMenu) {
		 topTaskMenuMapper.insert(topTaskMenu);
	}

	public List<TopTaskMenu> searchAll() {
		return topTaskMenuMapper.searchAll();
	}

	public PageInfo<TopTaskMenu> searchTopTaskMenu(Map searchMap) {
		TopTaskMenu topTaskMenu = (TopTaskMenu) searchMap.get("topTaskMenu");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopTaskMenu> list = topTaskMenuMapper.searchTopTaskMenu(topTaskMenu);
		PageInfo<TopTaskMenu> pageinfo = new PageInfo<TopTaskMenu>(list);
		return pageinfo;
	}

	public void update(TopTaskMenu TopTaskMenu) {
		topTaskMenuMapper.update(TopTaskMenu);
	}

	public TopTaskMenuMapper getTopTaskMenuMapper() {
		return topTaskMenuMapper;
	}

	public void setTopTaskMenuMapper(TopTaskMenuMapper TopTaskMenuMapper) {
		this.topTaskMenuMapper = TopTaskMenuMapper;
	}

	public List<TopTaskMenu> searchByRoleId(String roleId) {
		TopTaskMenu topTaskMenu = new TopTaskMenu();
		topTaskMenu.setRoleId(roleId);
		return this.topTaskMenuMapper.searchTopTaskMenu(topTaskMenu);
	}

	public int deleteByRoleId(String roleId) {
		
		return topTaskMenuMapper.deleteByRoleId(roleId);
	}
	
	
	

}
