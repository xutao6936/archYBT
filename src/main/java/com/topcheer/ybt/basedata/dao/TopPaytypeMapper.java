package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopPaytype;




public interface TopPaytypeMapper {
	
	public List<TopPaytype> searchTopPaytype(TopPaytype topPaytype);
	
	public List<TopPaytype> searchAll();
	
	public List<TopPaytype> getTopPaytype(String id);
	
	public void insert(TopPaytype topPaytype);
	
	public void update(TopPaytype topPaytype);
	
	public void delete(String id);

	public List<TopPaytype> getTopPaytypeListByInsPrdCode(String insPrdCode);
	
}
