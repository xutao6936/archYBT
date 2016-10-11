package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopAgentrateMapper;
import com.topcheer.ybt.basedata.entity.TopAgentrate;
import com.topcheer.ybt.basedata.service.ITopAgentrateService;



@Service("topAgentrateService")
@Transactional
public class TopAgentrateServiceImpl implements ITopAgentrateService{
	
	@Autowired
	protected TopAgentrateMapper topAgentrateMapper;

	public void delete(String id) {
		topAgentrateMapper.delete(id);
		
	}

	public List<TopAgentrate> getTopAgentrateList(String id) {
		return topAgentrateMapper.getTopAgentrate(id);
	}
	
	public TopAgentrate getTopAgentrate(String id) {
		List<TopAgentrate> list = topAgentrateMapper.getTopAgentrate(id);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopAgentrate topAgentrate) {
		 topAgentrateMapper.insert(topAgentrate);
	}

	public List<TopAgentrate> searchAll() {
		return topAgentrateMapper.searchAll();
	}

	public PageInfo<TopAgentrate> searchTopAgentrate(Map searchMap) {
		TopAgentrate topAgentrate = (TopAgentrate) searchMap.get("topAgentrate");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopAgentrate> list = topAgentrateMapper.searchTopAgentrate(topAgentrate);
		PageInfo<TopAgentrate> pageinfo = new PageInfo<TopAgentrate>(list);
		return pageinfo;
	}

	public void update(TopAgentrate TopAgentrate) {
		topAgentrateMapper.update(TopAgentrate);
	}

	public TopAgentrateMapper getTopAgentrateMapper() {
		return topAgentrateMapper;
	}

	public void setTopAgentrateMapper(TopAgentrateMapper TopAgentrateMapper) {
		this.topAgentrateMapper = TopAgentrateMapper;
	}

	@Override
	public List<TopAgentrate> getInsPrdByInsPrdCode(String insPrdCode) {
		List<TopAgentrate> list = topAgentrateMapper.getInsPrdByInsPrdCode(insPrdCode);
		return list;
	}

	@Override
	public PageInfo<TopAgentrate> getAgentrateByInsPrdCode(String insPrdCode) {
		List<TopAgentrate> list = topAgentrateMapper.getAgentrateByInsPrdCode(insPrdCode);
		PageInfo<TopAgentrate> pageinfo = new PageInfo<TopAgentrate>(list);
		return pageinfo;
	}

	@Override
	public void deleteByInsprdCode(String insprdCode) {
		topAgentrateMapper.deleteByInsprdCode(insprdCode);
	}


}
