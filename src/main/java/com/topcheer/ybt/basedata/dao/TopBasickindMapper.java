package com.topcheer.ybt.basedata.dao;

import java.util.List;
import com.topcheer.ybt.basedata.entity.TopBasickind;



public interface TopBasickindMapper {
	
	public List<TopBasickind> searchTopBasickind(TopBasickind topBasickind);
	
	public List<TopBasickind> searchAll();
	
	public List<TopBasickind> getTopBasickind(String id);
	
	public void insert(TopBasickind topBasickind);
	
	public void update(TopBasickind topBasickind);
	
	public void delete(String id);
	
}
