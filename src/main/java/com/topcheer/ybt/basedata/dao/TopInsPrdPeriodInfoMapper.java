package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;

public interface TopInsPrdPeriodInfoMapper {
	//查询保障年期信息
	public List<TopInsPrdPeriodInfo> searchAllTopInsPeriodInfo(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//插入保障年期信息
	public void insertTopInsPeriodInfo(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//更新保障年期信息
	public void updateTopInsPeriodInfo(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//删除保障年期信息
	public void deleteTopInsPeriodInfo(String  insPrdCode);

	public List getInsPrdPeriodByInsPrdCode(String insPrdCode);
}
