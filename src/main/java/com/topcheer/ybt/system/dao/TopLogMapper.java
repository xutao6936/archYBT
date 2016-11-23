package com.topcheer.ybt.system.dao;

import java.util.List;
import java.util.Map;

import com.topcheer.ybt.system.entity.TopLog;


public interface TopLogMapper {

	public List<TopLog> searchTopLog(TopLog topLog);

	public List<TopLog> searchAll();

	public List<TopLog> getTopLog(String id);

	public void insert(TopLog topLog);

	public void update(TopLog topLog);

	public void delete(String id);

	public List<TopLog> getExcptionLogInfo(TopLog topLog);

	public List<TopLog> getTopLogListByParams(Map<String, String> map);

	public List<TopLog> getExcptionLogListByParams(Map<String, String> map2);

}
