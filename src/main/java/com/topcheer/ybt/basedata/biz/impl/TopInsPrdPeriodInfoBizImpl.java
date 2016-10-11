package com.topcheer.ybt.basedata.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsPrdPeriodInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;
import com.topcheer.ybt.basedata.service.ITopInsPrdPeriodInfoService;

@Component
@Service(value = "topInsPeriodInfoBizImpl")
public class TopInsPrdPeriodInfoBizImpl implements ITopInsPrdPeriodInfoBiz{
	
	@Resource(name = "topInsPrdPeriodInfoService")
	ITopInsPrdPeriodInfoService  topInsPrdPeriodInfoService;
	@Override
	public PageInfo<TopInsPrdPeriodInfo> getInsPrdPeriodAllList(TopInsPrdPeriodInfo  topInsPrdPeriodInfo) {
		// TODO Auto-generated method stub
		return topInsPrdPeriodInfoService.getInsPrdPeriodAllList(topInsPrdPeriodInfo);
	}
	@Override
	public void insertInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo) {
		// TODO Auto-generated method stub
	      topInsPrdPeriodInfoService.insertInsPrdPeriod(topInsPrdPeriodInfo);
	}
	@Override
	public void updateInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo) {
		// TODO Auto-generated method stub
		topInsPrdPeriodInfoService.updateInsPrdPeriod(topInsPrdPeriodInfo);
	}
	@Override
	public void deleteInsPrdPeriod(String insPrdCode) {
		// TODO Auto-generated method stub
		topInsPrdPeriodInfoService.deleteInsPrdPeriod(insPrdCode);
	}
}
