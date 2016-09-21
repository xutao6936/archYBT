package com.topcheer.ybt.system.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.system.entity.TopMenuinfo;
import com.topcheer.ybt.system.entity.TopUserinfo;

public interface ITopMenuinfoService {

	public PageInfo<TopMenuinfo> searchTopMenuinfo(Map searchMap);

	public List<TopMenuinfo> getTopMenuinfoList(String menuId);

	public TopMenuinfo getTopMenuinfo(String menuId);

	public List<TopMenuinfo> searchMenuByUserId(TopUserinfo topUserinfo);

	public List<TopMenuinfo> searchAll();

	public void insert(TopMenuinfo topMenuinfo);

	public void update(TopMenuinfo topMenuinfo);

	public void delete(String id);

	public List<MenuResult> getTopMenusByUserId(String loginAccount);

}
