package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopPaytype;

public interface ITopPaytypeService {
	
	public PageInfo<TopPaytype> searchTopPaytype(Map<String,Object> searchMap);
	
	public List<TopPaytype> getTopPaytypeList(String id);
	
	public TopPaytype getTopPaytype(String id);
	
	public List<TopPaytype> searchAll();
	
	public void insert(TopPaytype topPaytype);
	
	public void update(TopPaytype topPaytype);
	
	public void delete(String id);

}
