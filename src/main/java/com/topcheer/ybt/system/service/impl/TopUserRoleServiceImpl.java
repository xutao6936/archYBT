package com.topcheer.ybt.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.dao.TopUserRoleMapper;
import com.topcheer.ybt.system.entity.TopUserRole;
import com.topcheer.ybt.system.service.ITopUserRoleService;

@Service("topUserRoleService")
@Transactional
public class TopUserRoleServiceImpl implements ITopUserRoleService {

	@Autowired
	protected TopUserRoleMapper topUserRoleMapper;

	public void delete(String id) {
		topUserRoleMapper.delete(id);

	}

	public List<TopUserRole> getTopUserRoleList(String userId) {
		TopUserRole role = new TopUserRole();
		role.setUserId(userId);
		return topUserRoleMapper.searchTopUserRole(role);
	}

	public TopUserRole getTopUserRole(String userId) {
		List<TopUserRole> list = topUserRoleMapper.getTopUserRole(userId);
		return (list == null) || (list.size() == 0l) ? null : list.get(0);
	}

	public void insert(TopUserRole topUserRole) {
		topUserRoleMapper.insert(topUserRole);
	}

	public List<TopUserRole> searchAll() {
		return topUserRoleMapper.searchAll();
	}

	public PageInfo<TopUserRole> searchTopUserRole(Map<String, Object> searchMap) {
		TopUserRole topUserRole = (TopUserRole) searchMap.get("topUserRole");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopUserRole> list = topUserRoleMapper.searchTopUserRole(topUserRole);
		PageInfo<TopUserRole> pageinfo = new PageInfo<TopUserRole>(list);
		return pageinfo;
	}

	public void update(TopUserRole TopUserRole) {
		topUserRoleMapper.update(TopUserRole);
	}

	public TopUserRoleMapper getTopUserRoleMapper() {
		return topUserRoleMapper;
	}

	public void setTopUserRoleMapper(TopUserRoleMapper TopUserRoleMapper) {
		this.topUserRoleMapper = TopUserRoleMapper;
	}

	public void deleteByUserId(String userId) {
		this.topUserRoleMapper.deleteByUserId(userId);

	}

}
