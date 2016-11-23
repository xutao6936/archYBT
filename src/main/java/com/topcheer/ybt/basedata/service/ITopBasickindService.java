package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopBasickind;


public interface ITopBasickindService {
	
	public PageInfo<TopBasickind> searchTopBasickind(Map searchMap);
	
	public List<TopBasickind> getTopBasickindList(String id);
	
	public TopBasickind getTopBasickind(String id);
	
	public List<TopBasickind> searchAll();
	
	public void insert(TopBasickind topBasickind);
	
	public void update(TopBasickind topBasickind);
	
	public void delete(String id);

}
