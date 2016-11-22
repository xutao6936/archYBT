package com.topcheer.ybt.system.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.entity.TopLog;


public interface ITopLogService {

	public PageInfo<TopLog> searchTopLog(Map searchMap);

	public List<TopLog> getTopLogList(String id);

	public TopLog getTopLog(String id);

	public List<TopLog> searchAll();

	public void insert(TopLog topLog);

	public void update(TopLog topLog);

	public void delete(String id);

	public PageInfo<TopLog> getExcptionLogInfo(Map<String, Object> map);

	public PageInfo<TopLog> getTopLogListByParams(Map<String, String> map);

	public PageInfo<TopLog> getExcptionLogListByParams(Map<String, String> map);

}
