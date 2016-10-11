package com.topcheer.ybt.basedata.biz;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;

public interface ITopInsPrdPeriodInfoBiz {
	
	 //取得保障年期基本信息表数据
	public PageInfo<TopInsPrdPeriodInfo> getInsPrdPeriodAllList(TopInsPrdPeriodInfo TopInsPrdPeriodInfo);
	
	//插入保障年期基本信息表数据
	public void insertInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//更新保障年期基本信息表数据
	public void updateInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo);
	
	//删除保障年期基本信息表数据
	public void deleteInsPrdPeriod(String  insPrdCode);

}
