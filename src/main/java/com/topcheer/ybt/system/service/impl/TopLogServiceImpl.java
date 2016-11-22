package com.topcheer.ybt.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.dao.TopLogMapper;
import com.topcheer.ybt.system.entity.TopLog;
import com.topcheer.ybt.system.service.ITopLogService;


@Service("topLogService")
@Transactional
public class TopLogServiceImpl implements ITopLogService {
	private static Logger logger =LoggerFactory.getLogger(TopLogServiceImpl.class);
	@Autowired
	private TopLogMapper mapper;

	public TopLogMapper getMapper() {
		return mapper;
	}

	public void setMapper(TopLogMapper mapper) {
		this.mapper = mapper;
	}
	public void delete(String id) {
		mapper.delete(id);

	}

	public List<TopLog> getTopLogList(String id) {
		return mapper.getTopLog(id);
	}

	public TopLog getTopLog(String id) {
		List<TopLog> list = mapper.getTopLog(id);
		return list == null || list.size() == 0l ? null : list.get(0);
	}

	public void insert(TopLog topLog) {
		mapper.insert(topLog);
	}

	public List<TopLog> searchAll() {
		return mapper.searchAll();
	}

	public PageInfo<TopLog> searchTopLog(Map searchMap) {
		TopLog topLog = (TopLog) searchMap.get("topLog");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopLog> list  = mapper.searchTopLog(topLog);
		PageInfo<TopLog> pageinfo = new PageInfo<TopLog>(list);
		return pageinfo;
	}

	public void update(TopLog TopLog) {
		mapper.update(TopLog);
	}

	public TopLogMapper getTopLogMapper() {
		return mapper;
	}

	public void setTopLogMapper(TopLogMapper TopLogMapper) {
		this.mapper = TopLogMapper;
	}

	@Override
	public PageInfo<TopLog> getExcptionLogInfo(Map<String, Object> map) {
		TopLog topLog = (TopLog) map.get("topLog");
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int pageNo = Integer.parseInt(map.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopLog> list  = mapper.getExcptionLogInfo(topLog);
		PageInfo<TopLog> pageinfo = new PageInfo<TopLog>(list);
		return pageinfo;
	}

	@Override
	public PageInfo<TopLog> getTopLogListByParams(Map<String, String> map) {
		String name = (String) map.get("name");
		String startDate = (String) map.get("startDate");
		String endDate = (String) map.get("endDate");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("createBy", name);
		map2.put("startDate", startDate);
		map2.put("endDate", endDate);
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int pageNo = Integer.parseInt(map.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopLog> list  = mapper.getTopLogListByParams(map2);
		PageInfo<TopLog> pageinfo = new PageInfo<TopLog>(list);
		return pageinfo;
	}

	@Override
	public PageInfo<TopLog> getExcptionLogListByParams(Map<String, String> map) {
		String name = (String) map.get("name");
		String startDate = (String) map.get("startDate");
		String endDate = (String) map.get("endDate");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("createBy", name);
		map2.put("startDate", startDate);
		map2.put("endDate", endDate);
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int pageNo = Integer.parseInt(map.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopLog> list  = mapper.getExcptionLogListByParams(map2);
		PageInfo<TopLog> pageinfo = new PageInfo<TopLog>(list);
		return pageinfo;
	}

}
