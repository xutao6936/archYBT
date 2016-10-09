package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopAgentrate;

public interface ITopAgentrateService {
	
	public PageInfo<TopAgentrate> searchTopAgentrate(Map searchMap);
	
	public List<TopAgentrate> getTopAgentrateList(String id);
	
	public TopAgentrate getTopAgentrate(String id);
	
	public List<TopAgentrate> searchAll();
	
	public void insert(TopAgentrate topAgentrate);
	
	public void update(TopAgentrate topAgentrate);
	
	public void delete(String id);

	public List<TopAgentrate> getInsPrdByInsPrdCode(String insPrdCode);

	public PageInfo<TopAgentrate> getAgentrateByInsPrdCode(String insPrdCode);

}
