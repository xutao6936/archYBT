package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopPaytypeMapper;
import com.topcheer.ybt.basedata.entity.TopPaytype;
import com.topcheer.ybt.basedata.service.ITopPaytypeService;

@Service("topPaytypeService")
public class TopPaytypeServiceImpl implements ITopPaytypeService{
	
	@Autowired
	protected TopPaytypeMapper topPaytypeMapper;

	public void delete(String id) {
		topPaytypeMapper.delete(id);
		
	}

	public List<TopPaytype> getTopPaytypeList(String id) {
		return topPaytypeMapper.getTopPaytype(id);
	}
	
	public TopPaytype getTopPaytype(String id) {
		List<TopPaytype> list = topPaytypeMapper.getTopPaytype(id);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopPaytype topPaytype) {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		topPaytype.setId(id);
		topPaytypeMapper.insert(topPaytype);
	}

	public List<TopPaytype> searchAll() {
		return topPaytypeMapper.searchAll();
	}

	public PageInfo<TopPaytype> searchTopPaytype(Map<String,Object> searchMap) {
		TopPaytype topPaytype = (TopPaytype) searchMap.get("topPaytype");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopPaytype> list = topPaytypeMapper.searchTopPaytype(topPaytype);
		PageInfo<TopPaytype> pageinfo = new PageInfo<TopPaytype>(list);
		return pageinfo;
	}

	public void update(TopPaytype TopPaytype) {
		topPaytypeMapper.update(TopPaytype);
	}

	public TopPaytypeMapper getTopPaytypeMapper() {
		return topPaytypeMapper;
	}

	public void setTopPaytypeMapper(TopPaytypeMapper TopPaytypeMapper) {
		this.topPaytypeMapper = TopPaytypeMapper;
	}

	@Override
	public List<TopPaytype> getTopPaytypeListByInsPrdCode(String insPrdCode) {
		return topPaytypeMapper.getTopPaytypeListByInsPrdCode(insPrdCode);
	}
	
	
	

}
