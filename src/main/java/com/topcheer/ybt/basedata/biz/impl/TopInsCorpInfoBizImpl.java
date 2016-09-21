package com.topcheer.ybt.basedata.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.service.ITopInsCorpInfoService;
@Component
@Service(value="topInsCorpInfoBizImpl")
public class TopInsCorpInfoBizImpl implements ITopInsCorpInfoBiz {
	
   @Autowired
	ITopInsCorpInfoService topInsCorpInfoService;
	@Override
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList() {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.getTopInsCorpInfoList();
	}

	@Override
	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(String insCorpCode) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.getInsCorpByinsCorpCode(insCorpCode);
	}

	@Override
	public int insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.insertTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.updateTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int deletetTopInsCorpInfo(String topInsCorpInfoCode) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.deletetTopInsCorpInfo(topInsCorpInfoCode);
	}

}
