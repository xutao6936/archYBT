package com.topcheer.ybt.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.dao.TopMenuRoleMapper;
import com.topcheer.ybt.system.dao.TopRoleinfoMapper;
import com.topcheer.ybt.system.dao.TopUserRoleMapper;
import com.topcheer.ybt.system.entity.TopRoleinfo;
import com.topcheer.ybt.system.service.ITopRoleinfoService;

@Service("topRoleinfoService")

public class TopRoleinfoServiceImpl implements ITopRoleinfoService {

	@Autowired
	protected TopRoleinfoMapper topRoleinfoMapper;
	
	@Autowired
	protected TopMenuRoleMapper topMenuRoleMapper;
	
	@Autowired
	protected TopUserRoleMapper topUserRoleMapper;

	@Transactional
	public void delete(String id) {
		//从用户角色表中删除当前角色的用户
		topUserRoleMapper.deleteByRoleId(id);
		//先从角色菜单表中删除当前角色的菜单
		topMenuRoleMapper.deleteByRoleId(id);
		//从角色表中删除角色信息
		topRoleinfoMapper.delete(id);
	}

	public List<TopRoleinfo> getTopRoleinfoList(String roleId) {
		return topRoleinfoMapper.getTopRoleinfo(roleId);
	}

	public TopRoleinfo getTopRoleinfo(String roleId) {
		List<TopRoleinfo> list = topRoleinfoMapper.getTopRoleinfo(roleId);
		return (list == null) || (list.size() == 0l) ? null : list.get(0);
	}

	public void insert(TopRoleinfo topRoleinfo) {
		topRoleinfoMapper.insert(topRoleinfo);
	}

	public List<TopRoleinfo> searchAll() {
		return topRoleinfoMapper.searchAll();
	}

	public PageInfo<TopRoleinfo> searchTopRoleinfo(Map searchMap) {
		TopRoleinfo topRoleinfo = (TopRoleinfo) searchMap.get("topRoleinfo");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopRoleinfo> list = topRoleinfoMapper.searchTopRoleinfo(topRoleinfo);
		PageInfo<TopRoleinfo> pageinfo = new PageInfo<TopRoleinfo>(list);
		return pageinfo;
	}

	public void update(TopRoleinfo TopRoleinfo) {
		topRoleinfoMapper.update(TopRoleinfo);
	}

	public TopRoleinfoMapper getTopRoleinfoMapper() {
		return topRoleinfoMapper;
	}

	public void setTopRoleinfoMapper(TopRoleinfoMapper TopRoleinfoMapper) {
		this.topRoleinfoMapper = TopRoleinfoMapper;
	}

}
