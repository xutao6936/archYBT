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
	public PageInfo<TopInsPrdPeriodInfo> getInsPrdPeriodAllList() {
		// TODO Auto-generated method stub
		return topInsPrdPeriodInfoService.getInsPrdPeriodAllList();
	}
}
