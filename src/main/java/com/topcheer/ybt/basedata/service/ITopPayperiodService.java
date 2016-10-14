package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopPayperiod;


public interface ITopPayperiodService {
	
	public PageInfo<TopPayperiod> searchTopPayperiod(Map<String,Object> searchMap);
	
	public List<TopPayperiod> getTopPayperiodList(String id);
	
	public TopPayperiod getTopPayperiod(String id);
	
	public List<TopPayperiod> searchAll();
	
	public void insert(TopPayperiod topPayperiod);
	
	public void update(TopPayperiod topPayperiod);
	
	public void delete(String id);

}
