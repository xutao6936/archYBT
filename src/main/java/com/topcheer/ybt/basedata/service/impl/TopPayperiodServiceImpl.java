package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopPayperiodMapper;
import com.topcheer.ybt.basedata.entity.TopPayperiod;
import com.topcheer.ybt.basedata.service.ITopPayperiodService;

@Service("topPayperiodService")
public class TopPayperiodServiceImpl implements ITopPayperiodService{
	
	@Autowired
	protected TopPayperiodMapper topPayperiodMapper;

	public void delete(String id) {
		topPayperiodMapper.delete(id);
		
	}

	public List<TopPayperiod> getTopPayperiodList(String id) {
		return topPayperiodMapper.getTopPayperiod(id);
	}
	
	public TopPayperiod getTopPayperiod(String id) {
		List<TopPayperiod> list = topPayperiodMapper.getTopPayperiod(id);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopPayperiod topPayperiod) {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		topPayperiod.setId(id);
		topPayperiodMapper.insert(topPayperiod);
	}

	public List<TopPayperiod> searchAll() {
		return topPayperiodMapper.searchAll();
	}

	public PageInfo<TopPayperiod> searchTopPayperiod(Map<String,Object> searchMap) {
		TopPayperiod topPayperiod = (TopPayperiod) searchMap.get("topPayperiod");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopPayperiod> list = topPayperiodMapper.searchTopPayperiod(topPayperiod);
		PageInfo<TopPayperiod> pageinfo = new PageInfo<TopPayperiod>(list);
		return pageinfo;
	}

	public void update(TopPayperiod TopPayperiod) {
		topPayperiodMapper.update(TopPayperiod);
	}

	public TopPayperiodMapper getTopPayperiodMapper() {
		return topPayperiodMapper;
	}

	public void setTopPayperiodMapper(TopPayperiodMapper TopPayperiodMapper) {
		this.topPayperiodMapper = TopPayperiodMapper;
	}
	
	
	

}
