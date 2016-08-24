package com.topcheer.ybt.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.topcheer.ybt.dao.system.TopRoleinfoMapper;
import com.topcheer.ybt.entity.system.TopRoleinfo;
import com.topcheer.ybt.service.system.ITopRoleinfoService;


@Service("topRoleinfoService")
@Transactional
public class TopRoleinfoServiceImpl implements ITopRoleinfoService{
	
	@Autowired
	protected TopRoleinfoMapper topRoleinfoMapper;

	public void delete(String id) {
		topRoleinfoMapper.delete(id);
		
	}

	public List<TopRoleinfo> getTopRoleinfoList(String roleId) {
		return topRoleinfoMapper.getTopRoleinfo(roleId);
	}
	
	public TopRoleinfo getTopRoleinfo(String roleId) {
		List<TopRoleinfo> list = topRoleinfoMapper.getTopRoleinfo(roleId);
		return list==null||list.size()==0l?null:list.get(0);
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
		PageHelper.startPage(pageNo, pageSize,true, true, true);
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
