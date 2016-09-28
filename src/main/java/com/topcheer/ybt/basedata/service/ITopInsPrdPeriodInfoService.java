package com.topcheer.ybt.basedata.service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;

public interface ITopInsPrdPeriodInfoService {
	
	//取得保险产品基本信息表数据
	public PageInfo<TopInsPrdPeriodInfo> getInsPrdPeriodAllList();

}
