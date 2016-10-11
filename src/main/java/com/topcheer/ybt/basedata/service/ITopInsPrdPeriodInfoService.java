package com.topcheer.ybt.basedata.service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;

public interface ITopInsPrdPeriodInfoService {
	
	//取得保险产品基本信息表数据
	public PageInfo<TopInsPrdPeriodInfo> getInsPrdPeriodAllList(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//插入保障年期基本信息
	public void insertInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//更新保障年期基本信息
	public void updateInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//删除保障年期基本信息
	public void deleteInsPrdPeriod(String  insPrdCode);
}
