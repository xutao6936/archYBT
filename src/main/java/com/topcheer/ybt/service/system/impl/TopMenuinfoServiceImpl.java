package com.topcheer.ybt.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.dao.system.TopMenuinfoMapper;
import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.entity.system.TopMenuinfo;
import com.topcheer.ybt.service.system.ITopMenuinfoService;


@Service("topMenuinfoService")
@Transactional
public class TopMenuinfoServiceImpl implements ITopMenuinfoService{
	
	@Autowired
	protected TopMenuinfoMapper topMenuinfoMapper;

	public void delete(String id) {
		topMenuinfoMapper.delete(id);
		
	}

	public List<TopMenuinfo> getTopMenuinfoList(String menuId) {
		return topMenuinfoMapper.getTopMenuinfo(menuId);
	}
	
	public TopMenuinfo getTopMenuinfo(String menuId) {
		List<TopMenuinfo> list = topMenuinfoMapper.getTopMenuinfo(menuId);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopMenuinfo topMenuinfo) {
		 topMenuinfoMapper.insert(topMenuinfo);
	}

	public List<TopMenuinfo> searchAll() {
		return topMenuinfoMapper.searchAll();
	}

	public PageInfo<TopMenuinfo> searchTopMenuinfo(Map searchMap) {
		TopMenuinfo topMenuinfo = (TopMenuinfo) searchMap.get("topMenuinfo");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
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

}
