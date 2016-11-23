package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopBasickindMapper;
import com.topcheer.ybt.basedata.entity.TopBasickind;
import com.topcheer.ybt.basedata.service.ITopBasickindService;



@Service("topBasickindService")
@Transactional
public class TopBasickindServiceImpl implements ITopBasickindService{
	
	@Autowired
	protected TopBasickindMapper topBasickindMapper;

	public void delete(String id) {
		topBasickindMapper.delete(id);
		
	}

	public List<TopBasickind> getTopBasickindList(String id) {
		return topBasickindMapper.getTopBasickind(id);
	}
	
	public TopBasickind getTopBasickind(String id) {
		List<TopBasickind> list = topBasickindMapper.getTopBasickind(id);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopBasickind topBasickind) {
		 topBasickindMapper.insert(topBasickind);
	}

	public List<TopBasickind> searchAll() {
		return topBasickindMapper.searchAll();
	}

	public PageInfo<TopBasickind> searchTopBasickind(Map searchMap) {
		TopBasickind topBasickind = (TopBasickind) searchMap.get("topBasickind");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopBasickind> list = topBasickindMapper.searchTopBasickind(topBasickind);
		PageInfo<TopBasickind> pageinfo = new PageInfo<TopBasickind>(list);
		return pageinfo;
	}

	public void update(TopBasickind TopBasickind) {
		topBasickindMapper.update(TopBasickind);
	}

	public TopBasickindMapper getTopBasickindMapper() {
		return topBasickindMapper;
	}

	public void setTopBasickindMapper(TopBasickindMapper TopBasickindMapper) {
		this.topBasickindMapper = TopBasickindMapper;
	}
	
	
	

}
