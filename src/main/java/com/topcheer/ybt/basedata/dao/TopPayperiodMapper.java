package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopPayperiod;


public interface TopPayperiodMapper {
	
	public List<TopPayperiod> searchTopPayperiod(TopPayperiod topPayperiod);
	
	public List<TopPayperiod> searchAll();
	
	public List<TopPayperiod> getTopPayperiod(String id);
	
	public void insert(TopPayperiod topPayperiod);
	
	public void update(TopPayperiod topPayperiod);
	
	public void delete(String id);
	
}
