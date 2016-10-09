package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;

public interface TopInsPrdPeriodInfoMapper {
	//查询保障年期信息
	public List<TopInsPrdPeriodInfo> searchAllTopInsPeriodInfo();
}
