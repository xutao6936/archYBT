package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopAgentrate;


public interface TopAgentrateMapper {
	
	public List<TopAgentrate> searchTopAgentrate(TopAgentrate topAgentrate);
	
	public List<TopAgentrate> searchAll();
	
	public List<TopAgentrate> getTopAgentrate(String id);
	
	public void insert(TopAgentrate topAgentrate);
	
	public void update(TopAgentrate topAgentrate);
	
	public void delete(String id);

	public List<TopAgentrate> getInsPrdByInsPrdCode(String insPrdCode);

	public List<TopAgentrate> getAgentrateByInsPrdCode(String insPrdCode);
	
}
