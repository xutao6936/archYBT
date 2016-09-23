package com.topcheer.ybt.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.system.dao.TopMenuRoleMapper;
import com.topcheer.ybt.system.dao.TopMenuinfoMapper;
import com.topcheer.ybt.system.entity.TopMenuinfo;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.system.service.ITopMenuinfoService;

@Service("topMenuinfoService")
@Transactional
public class TopMenuinfoServiceImpl implements ITopMenuinfoService {

	@Autowired
	protected TopMenuinfoMapper topMenuinfoMapper;
	
	@Autowired
	protected TopMenuRoleMapper topMenuRoleMapper;

	@Transactional
	public void delete(String id) {
		//从角色菜单中删除拥有当前菜单的角色记录
		topMenuRoleMapper.deleteByMenuId(id);
		//从菜单表中删除当前菜单
		topMenuinfoMapper.delete(id);
	}

	public List<TopMenuinfo> getTopMenuinfoList(String menuId) {
		return topMenuinfoMapper.getTopMenuinfo(menuId);
	}

	public TopMenuinfo getTopMenuinfo(String menuId) {
		List<TopMenuinfo> list = topMenuinfoMapper.getTopMenuinfo(menuId);
		return (list == null) || (list.size() == 0l) ? null : list.get(0);
	}

	public void insert(TopMenuinfo topMenuinfo) {
		topMenuinfoMapper.insert(topMenuinfo);
	}

	public List<TopMenuinfo> searchAll(TopUserinfo topUserinfo) {
		return topMenuinfoMapper.searchMenuByUserId(topUserinfo.getUserId());
	}

	public PageInfo<TopMenuinfo> searchTopMenuinfo(Map<String,Object> searchMap) {
		TopMenuinfo topMenuinfo = (TopMenuinfo) searchMap.get("topMenuinfo");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopMenuinfo> list = topMenuinfoMapper.searchTopMenuinfo(topMenuinfo);
		PageInfo<TopMenuinfo> pageinfo = new PageInfo<TopMenuinfo>(list);
		return pageinfo;
	}

	public void update(TopMenuinfo TopMenuinfo) {
		topMenuinfoMapper.update(TopMenuinfo);
	}

	public TopMenuinfoMapper getTopMenuinfoMapper() {
		return topMenuinfoMapper;
	}

	public void setTopMenuinfoMapper(TopMenuinfoMapper TopMenuinfoMapper) {
		this.topMenuinfoMapper = TopMenuinfoMapper;
	}

	public List<MenuResult> getTopMenusByUserId(String loginAccount) {
		List<MenuResult> list = topMenuinfoMapper.getTopMenusByUserId(loginAccount);
		return list;
	}

	public List<TopMenuinfo> searchAll() {
		return topMenuinfoMapper.searchAll();
	}

	public List<TopMenuinfo> searchMenuByUserId(TopUserinfo topUserinfo) {
		return topMenuinfoMapper.searchMenuByUserId(topUserinfo.getUserId());
	}

}
