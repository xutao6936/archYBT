package com.topcheer.ybt.system.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.entity.TopRoleinfo;

public interface ITopRoleinfoService {

	public PageInfo<TopRoleinfo> searchTopRoleinfo(Map searchMap);

	public List<TopRoleinfo> getTopRoleinfoList(String roleId);

	public TopRoleinfo getTopRoleinfo(String roleId);

	public List<TopRoleinfo> searchAll();

	public void insert(TopRoleinfo topRoleinfo);

	public void update(TopRoleinfo topRoleinfo);

	public void delete(String id);

}
