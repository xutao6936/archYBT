package com.topcheer.ybt.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.dao.TopMenuRoleMapper;
import com.topcheer.ybt.system.entity.TopMenuRole;
import com.topcheer.ybt.system.service.ITopMenuRoleService;

@Service("topMenuRoleService")
public class TopMenuRoleServiceImpl implements ITopMenuRoleService{
	
	@Autowired
	protected TopMenuRoleMapper topMenuRoleMapper;

	public void delete(String id) {
		topMenuRoleMapper.delete(id);
		
	}

	public List<TopMenuRole> getTopMenuRoleList(String id) {
		return topMenuRoleMapper.getTopMenuRole(id);
	}
	
	public TopMenuRole getTopMenuRole(String id) {
		List<TopMenuRole> list = topMenuRoleMapper.getTopMenuRole(id);
		return list==null||list.size()==0l?null:list.get(0);
	}

	
	public void insert(TopMenuRole topMenuRole) {
		 this.topMenuRoleMapper.insert(topMenuRole);
	}

	public List<TopMenuRole> searchAll() {
		return topMenuRoleMapper.searchAll();
	}

	public PageInfo<TopMenuRole> searchTopMenuRole(Map searchMap) {
		TopMenuRole topMenuRole = (TopMenuRole) searchMap.get("topMenuRole");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopMenuRole> list = topMenuRoleMapper.searchTopMenuRole(topMenuRole);
		PageInfo<TopMenuRole> pageinfo = new PageInfo<TopMenuRole>(list);
		return pageinfo;
	}

	public void update(TopMenuRole TopMenuRole) {
		topMenuRoleMapper.update(TopMenuRole);
	}

	public TopMenuRoleMapper getTopMenuRoleMapper() {
		return topMenuRoleMapper;
	}

	public void setTopMenuRoleMapper(TopMenuRoleMapper TopMenuRoleMapper) {
		this.topMenuRoleMapper = TopMenuRoleMapper;
	}

	public List<TopMenuRole> searchMenuByRoleId(String id) {
		return this.topMenuRoleMapper.searchMenuByRoleId(id);
	}

	public int deleteByRoleId(String roleId) {
		return this.topMenuRoleMapper.deleteByRoleId(roleId);
	}

	@Transactional
	public void updateMenuByRoleId(TopMenuRole topMenuRole) throws Exception{
		String roleId = topMenuRole.getRoleId();//角色编码
		String ids = topMenuRole.getMenuId();//菜单id
		topMenuRoleMapper.deleteByRoleId(roleId);
		
		if (!"".equals(ids)) {
			String[] strs = ids.split("\\,");
			for (String str : strs) {
				TopMenuRole newMenu = new TopMenuRole();
				newMenu.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				newMenu.setMenuId(str);//菜单编号
				newMenu.setRoleId(roleId);//角色编号
				topMenuRoleMapper.insert(newMenu);
			}
			
		}
		
	}
	
}
